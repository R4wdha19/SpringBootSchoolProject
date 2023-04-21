package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "SchoolStudentsReport")
    public String generateSchoolReports() throws Exception {
        return reportService.generateSchoolStudentsReport();
    }

    @RequestMapping(value = "CoursesAndMarksReport")
    public String generateCoursesAndMarksReport() throws Exception {
        return reportService.generateCourseMarksReport();
    }

    @RequestMapping(value = "CoursesAndAverageMarksReport")
    public String generateCoursesAndAverageMarksReport() throws Exception {
        return reportService.averageMarksReport();
    }

    @RequestMapping(value = "TopPerformingStudentInEachSchool")
    public String generateTopPerformingStudentInEachSchool() throws Exception {
        return reportService.generateTopPerformingStudentInEachSchool();
    }

    @RequestMapping(value = "generateOverAllStudentPerformance")
    public String generateOverAllStudentPerformance() throws Exception {
        return reportService.generateOverAllStudentPerformance();
    }

    @RequestMapping(value = "generateTotalNumberOfStudentsInEachSchool")
    public String generateTotalNumberOfStudentsInEachSchool() throws Exception {
        return reportService.generateTotalNumberOfStudentsInEachSchool();
    }

    @RequestMapping(value = "generateDistributionOfGradesReport")
    public String generateDistributionOfGradesReport() throws Exception {
        return reportService.generateTheDistributionOfGrades();
    }

    @RequestMapping(value = "generateTopPerformanceCoursesInEachSchoolReport")
    public String generateTopPerformanceCoursesInEachSchool() throws Exception {
        return reportService.generateTopPerformanceCoursesInEachSchool();
    }
}
