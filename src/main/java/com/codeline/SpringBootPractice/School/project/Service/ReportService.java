package com.codeline.SpringBootPractice.School.project.Service;


import com.codeline.SpringBootPractice.School.project.DTO.CourseMarkObject;
import com.codeline.SpringBootPractice.School.project.DTO.StudentSchoolObject;
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
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
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

    public static final String pathToReports = "C:\\Users\\user013\\Downloads\\Reports";

    public String generateTestingReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();
        File file = ResourceUtils.getFile("classpath:SchoolFiles.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\testingSchools.pdf");
        return "Report generated : " + pathToReports + "\\testingSchools.pdf";
    }

    public String generateSchoolStudentsReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();
        List<StudentSchoolObject> allSchoolsWithTheirStudents = new ArrayList<>();

        for (Student studentObject : studentList) {
            StudentSchoolObject studentSchoolObject = new StudentSchoolObject();
            studentSchoolObject.setSchoolName(studentObject.getSchool().getSchoolName());
            studentSchoolObject.setStudentName(studentObject.getStudentName());
            studentSchoolObject.setStudentRollNumber(studentObject.getStudentRollNumber());
            allSchoolsWithTheirStudents.add(studentSchoolObject);
        }
        File file = ResourceUtils.getFile("classpath:StudentsAndSchools.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(allSchoolsWithTheirStudents);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\allSchoolsWithTheirStudents.pdf");
        return "Report generated : " + pathToReports + "\\allSchoolsWithTheirStudents.pdf";
    }

    public String generateCourseMarksReport() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();
        List<CourseMarkObject> courseMarkObject = new ArrayList<>();
        for (Mark coursesAndMarks : markList) {
            CourseMarkObject markObject = new CourseMarkObject();
            markObject.setCourseName(coursesAndMarks.getCourse().getCourseName());
            markObject.setObtainedMarks(coursesAndMarks.getObtainedMarks());
            markObject.setGrade(coursesAndMarks.getGrade());
            courseMarkObject.add(markObject);
        }
        File file = ResourceUtils.getFile("classpath:CourseAndMark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkObject);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CoursesAndMarksReport.pdf");
        return "Report generated : " + pathToReports + "\\CoursesAndMarksReport.pdf";
    }
//    public String generateAverageMarksReport() throws FileNotFoundException, JRException {
//        List<School> schoolList = schoolRepository.getAllSchools();
//        File file = ResourceUtils.getFile("classpath:SchoolFiles.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("CreatedBy", "R");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , dataSource);  //fillReport combine it all
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\AverageMarks.pdf");
//        return "Report generated : " + pathToReports+"\\AverageMarks.pdf";
//    }


    public String averageMarksReport() throws FileNotFoundException, JRException {
        List<Mark> marksList = markRepository.getAllMarks();
        List<CourseMarkObject> courseMarkObject = new ArrayList<>();
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

        for(String keyCourseName: courseMapWithMark.keySet()){
            Integer numberOfMarkByCourse = markRepository.getNumberOfMarksByCourseName(keyCourseName);
            Integer marks = courseMapWithMark.get(keyCourseName);
            Integer average = marks/numberOfMarkByCourse;
            CourseMarkObject markObject = new CourseMarkObject();
            markObject.setAverageMark(average);
            markObject.setCourseName(keyCourseName);
            courseMarkObject.add(markObject);
        }
        File file = ResourceUtils.getFile("classpath:AverageMark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkObject);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AverageMarkReport.pdf");
        return "Report generated : " + pathToReports + "\\AverageMarkReport.pdf";
    }
}
