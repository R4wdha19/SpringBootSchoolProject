package com.codeline.SpringBootPractice.School.project.Service;


import com.codeline.SpringBootPractice.School.project.DTO.StudentSchoolObject;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
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

    public static final String pathToReports = "";
    public String generateTestingReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();
        File file = ResourceUtils.getFile("classpath:SchoolFiles.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\testingSchools.pdf");
        return "Report generated : " + pathToReports+"\\testingSchools.pdf";
    }

    public String generateSchoolStudentsReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();
        List<StudentSchoolObject> allSchoolsWithTheirStudents =new ArrayList<>();

        for(Student studentObject : studentList){
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
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\allSchoolsWithTheirStudents.pdf");
        return "Report generated : " + pathToReports+"\\allSchoolsWithTheirStudents.pdf";
    }

//    public String generateCoursesReport() throws FileNotFoundException, JRException {
//        List<School> schoolList = schoolRepository.getAllSchools();
//        File file = ResourceUtils.getFile("classpath:SchoolFiles.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("CreatedBy", "R");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , dataSource);  //fillReport combine it all
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\AllCourses.pdf");
//        return "Report generated : " + pathToReports+"\\AllCourses.pdf";
//    }
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
}
