package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {
@Autowired
CourseService courseService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses = courseService.getAllCourses();
        return courses;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        return course;

    }
@RequestMapping(value = "/getByName",method = RequestMethod.GET)
    public List<Course> getCourseByName(@RequestParam String courseName){
       List<Course>  course = courseService.getCourseByName(courseName);
        return course;
    }

    @RequestMapping(value = "getAllActiveCourses", method = RequestMethod.GET)
    public List<Course> getAllActiveCourses(){
        List<Course> activeCourseList = new ArrayList<>();
        activeCourseList = courseService.getAllActiveCourses();
        return activeCourseList;
    }

    @RequestMapping(value = "getAllInActiveCourses", method = RequestMethod.GET)
    public List<Course> getAllInActiveCourses(){
        List<Course> inActiveCourseList = new ArrayList<>();
        inActiveCourseList = courseService.getAllInActiveCourses();
        return inActiveCourseList;
    }
    @RequestMapping(value = "getCourseCreatedAfterDate", method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(){
        List<Course> courseList = new ArrayList<>();
        courseList = courseService.getCourseCreatedAfterDate();
        return courseList;
    }
}
