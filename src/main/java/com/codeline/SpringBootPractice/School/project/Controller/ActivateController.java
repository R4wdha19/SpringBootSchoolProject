package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.CourseService;
import com.codeline.SpringBootPractice.School.project.Service.MarkService;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import com.codeline.SpringBootPractice.School.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivateController {


    @Autowired
    StudentService studentService;


    @Autowired
    SchoolService schoolService;

    @Autowired
    CourseService courseService;

    @Autowired
    MarkService markService;

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;

    }

    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses = courseService.getAllCourses();
        return courses;
    }

    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks(){
        List<Mark> marks = new ArrayList<>();
        marks = markService.getAllMarks();
        return marks;
    }
    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        students = studentService.getAllStudents();
        return students;
    }

}
