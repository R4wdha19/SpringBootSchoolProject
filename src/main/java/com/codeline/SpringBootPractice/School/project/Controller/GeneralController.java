package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.CourseService;
import com.codeline.SpringBootPractice.School.project.Service.MarkService;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import com.codeline.SpringBootPractice.School.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    

    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
       return studentService.getStudentsBySchoolName(schoolName);

    }
    @RequestMapping(value = "course/getCoursesByStudentName",method = RequestMethod.GET)
    public List<Course> getCoursesByStudentName(@RequestParam String studentName){
        return courseService.getCoursesByStudentName(studentName);
    }
}
