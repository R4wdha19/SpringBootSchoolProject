package com.codeline.SpringBootPractice.School.project.Service;


import com.codeline.SpringBootPractice.School.project.DTO.*;
import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.CourseRepository;
import com.codeline.SpringBootPractice.School.project.Repository.MarkRepository;
import com.codeline.SpringBootPractice.School.project.Repository.SchoolRepository;
import com.codeline.SpringBootPractice.School.project.Repository.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MarkRepository markRepository;

    public static final String pathToReports = "C:\\Users\\Admin\\Desktop\\roodh\\Reports";

    public String generateTestingReport() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        return generateAReport("SchoolFiles", "testingSchools", dataSource);
    }

    public String generateSchoolStudentsReport() throws Exception {
        List<Student> studentList = studentRepository.getAllStudents();
        List<StudentSchoolDTOObject> allSchoolsWithTheirStudents = new ArrayList<>();

        for (Student studentObject : studentList) {
            StudentSchoolDTOObject studentSchoolDTOObject = new StudentSchoolDTOObject();
            studentSchoolDTOObject.setSchoolName(studentObject.getSchool().getSchoolName());
            studentSchoolDTOObject.setStudentName(studentObject.getStudentName());
            studentSchoolDTOObject.setStudentRollNumber(studentObject.getStudentRollNumber());
            allSchoolsWithTheirStudents.add(studentSchoolDTOObject);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(allSchoolsWithTheirStudents);
        return generateAReport("ReportService", "allSchoolsWithTheirStudents", dataSource);

    }

    public String generateCourseMarksReport() throws Exception {
        List<Mark> markList = markRepository.getAllMarks();
        List<CourseMarkDTOObject> courseMarkObject = new ArrayList<>();
        for (Mark coursesAndMarks : markList) {
            CourseMarkDTOObject markObject = new CourseMarkDTOObject();
            markObject.setCourseName(coursesAndMarks.getCourse().getCourseName());
            markObject.setObtainedMarks(coursesAndMarks.getObtainedMarks());
            markObject.setGrade(coursesAndMarks.getGrade());
            courseMarkObject.add(markObject);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkObject);
        return generateAReport("CourseAndMark", "CoursesAndMarksReport", dataSource);
    }


    public String averageMarksReport() throws Exception {
        List<Mark> marksList = markRepository.getAllMarks();
        List<CourseMarkDTOObject> courseMarkObject = new ArrayList<>();
        Map<String, Integer> courseMapWithMark = new HashMap<>();
        for (Mark m : marksList) {
            String courseName = m.getCourse().getCourseName();
            if (!courseMapWithMark.containsKey(courseName)) {
                courseMapWithMark.put(courseName, m.getObtainedMarks());
            } else {
                Integer previousCourseMark = courseMapWithMark.get(courseName);
                previousCourseMark = previousCourseMark + m.getObtainedMarks();
                courseMapWithMark.put(courseName, previousCourseMark);
            }
        }
        for (String keyCourseName : courseMapWithMark.keySet()) {
            Integer numberOfMarkByCourse = markRepository.getNumberOfMarksByCourseName(keyCourseName);
            Integer marks = courseMapWithMark.get(keyCourseName);
            Integer average = marks / numberOfMarkByCourse;
            CourseMarkDTOObject markObject = new CourseMarkDTOObject();
            markObject.setAverageMark(average);
            markObject.setCourseName(keyCourseName);
            courseMarkObject.add(markObject);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkObject);
        return generateAReport("AverageMark", "AverageMarkReport", dataSource);
    }

    public String generateTopPerformingStudentInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        Map<School, Student> schoolStudentMap = new HashMap<>();
        List<TopPerformingStudentDTO> topPreformingStudentDTOSList = new ArrayList<>();

        for (School school : schoolList) {
            List<Student> studentList = studentRepository.getStudentBySchoolId(school.getId());
            Integer highestMarks = 0;
            Student studentWithHighestMarks = new Student();
            for (Student student : studentList) {
                Integer studentId = student.getId();
                Integer studentTotalMark = markRepository.getSumOfMarksByStudentId(studentId);
                if (studentTotalMark != null && studentTotalMark > highestMarks) {
                    highestMarks = studentTotalMark;
                    studentWithHighestMarks = student;
                }
            }
            schoolStudentMap.put(school, studentWithHighestMarks);
            topPreformingStudentDTOSList.add(new TopPerformingStudentDTO(studentWithHighestMarks.getStudentName(), school.getSchoolName()));
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPreformingStudentDTOSList);
        return generateAReport("TopPerformingStudent", "TopPerformingStudent", dataSource);
    }

    public String generateOverAllStudentPerformance() throws Exception {
        List<Student> studentList = studentRepository.getAllStudents();
        List<StudentMarkDTO> studentMarkDTOS = new ArrayList<>();
        for (Student student : studentList) {
            Integer studentId = student.getId();
            Integer studentRollNumber = student.getStudentRollNumber();
            String studentName = student.getStudentName();
            Integer avgOfMarksByStudentId = markRepository.getAvgOfMarksByStudentId(studentId);
            StudentMarkDTO studentDto = new StudentMarkDTO(studentId, studentRollNumber, studentName, avgOfMarksByStudentId);
            studentMarkDTOS.add(studentDto);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentMarkDTOS);
        return generateAReport("OverallStudentPerformance", "OverallStudentPerformanceReport", dataSource);
    }

    public String generateTotalNumberOfStudentsInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<CountOfStudentWithSchoolDTO> countOfStudent = new ArrayList<>();
        for (School school : schoolList) {
            Integer schoolId = school.getId();
            String schoolName = school.getSchoolName();
            Integer countOfStudents = studentRepository.getCountOfStudentsBySchoolId(schoolId);
            CountOfStudentWithSchoolDTO countOfStudentWithSchoolDTO = new CountOfStudentWithSchoolDTO(schoolName, countOfStudents);
            countOfStudent.add(countOfStudentWithSchoolDTO);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(countOfStudent);
        return generateAReport("CountOfStudentsBySchool", "CountOfStudentsBySchool", dataSource);
    }

    public String generateTheDistributionOfGrades() throws Exception {
        List<String> coursesNames = courseRepository.getAllCoursesNames();
        List<String> listOfUniqueGrades = markRepository.getDistinctGrades();
        List<CourseWithGradesDTO> courseWithGradesDTOS = new ArrayList<>();
        for (String courseName : coursesNames) {
            for (String grade : listOfUniqueGrades) {
                Integer countOfMarksByGradeAndCourseName = markRepository.getCountOfMarksByGradeAndCourseName(grade, courseName);
                courseWithGradesDTOS.add(new CourseWithGradesDTO(courseName, grade, countOfMarksByGradeAndCourseName));
            }
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseWithGradesDTOS);
        return generateAReport("TheDistributionOfGrades", "TheDistributionOfGrades!", dataSource);
    }

    public String generateTopPerformanceCoursesInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        Map<School, Course> schoolCourseMap = new HashMap<>();
        List<TopPerformingCourseDTO> topPerformingCourseDTOS = new ArrayList<>();
        for (School school : schoolList) {
            Integer schoolId = school.getId();
            List<Course> courseList = courseRepository.getCourseBySchoolId(schoolId);
            for (Course course : courseList) {
                String schoolName = school.getSchoolName();
                String courseName = course.getCourseName();
                Integer courseId = course.getId();
                Integer topPerformingCourse = markRepository.averageMarkForCourse(courseId);
                schoolCourseMap.put(school, course);
                topPerformingCourseDTOS.add(new TopPerformingCourseDTO(schoolName, courseName));
            }
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPerformingCourseDTOS);
        return generateAReport("topPerformingCourse", "TopPerformingCourseInEachSchool", dataSource);
    }


    public String generateAReport(String jasperReportName, String fileName, JRBeanCollectionDataSource dataSource) throws Exception {
        File file = new File("C:\\Users\\Admin\\Documents\\GitHub\\SpringBootSchoolProject\\src\\main\\resources\\" + jasperReportName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\" + fileName + ".pdf");
        return "Report generated : " + pathToReports + "\\" + fileName + ".pdf";
    }
}
