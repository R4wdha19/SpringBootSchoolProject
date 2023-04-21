package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.*;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class GeneralController {


    @Autowired
    StudentService studentService;


    @Autowired
    SchoolService schoolService;

    @Autowired
    CourseService courseService;

    @Autowired
    MarkService markService;
    @Autowired
    SlackClient slackClient;
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
        return studentService.getStudentsBySchoolName(schoolName);

    }

    @RequestMapping(value = "course/getCoursesByStudentName", method = RequestMethod.GET)
    public List<Course> getCoursesByStudentName(@RequestParam String studentName) {
        return courseService.getCoursesByStudentName(studentName);
    }

    @GetMapping(value = "slackMessage")
    public void message(@RequestParam String text){
        slackClient.sendMessage(text);
    }


}
