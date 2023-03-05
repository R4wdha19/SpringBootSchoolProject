package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses = courseService.getAllCourses();
        return courses;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        return course;

    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    public List<Course> getCourseByName(@RequestParam String courseName) {
        List<Course> course = courseService.getCourseByName(courseName);
        return course;
    }

    @RequestMapping(value = "getAllActiveCourses", method = RequestMethod.GET)
    public List<Course> getAllActiveCourses() {
        List<Course> activeCourseList = new ArrayList<>();
        activeCourseList = courseService.getAllActiveCourses();
        return activeCourseList;
    }

    @RequestMapping(value = "getAllInActiveCourses", method = RequestMethod.GET)
    public List<Course> getAllInActiveCourses() {
        List<Course> inActiveCourseList = new ArrayList<>();
        inActiveCourseList = courseService.getAllInActiveCourses();
        return inActiveCourseList;
    }

    @RequestMapping(value = "getCourseCreatedAfterDate", method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Course> courseList = new ArrayList<>();
        courseList = courseService.getCourseCreatedAfterDate(createdDate);
        return courseList;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Course getLatestRow() {
        Course course = courseService.getLatestRow();
        return course;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public Course getLatestUpdatedDate() {
        Course course = courseService.getLatestUpdatedDate();
        return course;
    }

    @RequestMapping(value = "deleteCourseById", method = RequestMethod.POST)
    public void deleteCourseById(@RequestParam Integer courseId) {
        courseService.deleteCourseById(courseId);
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }

    @RequestMapping(value = "deleteCourseByName", method = RequestMethod.POST)
    public void deleteCourseByName(@RequestParam String courseName) {
        courseService.deleteCourseByName(courseName);
    }

    @RequestMapping(value = "createCourse", method = RequestMethod.POST)
    public void createCourse(@RequestParam String courseName, Integer studentId) {
        courseService.createCourse(courseName, studentId);
    }
    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByCreatedDate(@RequestParam String createdDate) throws ParseException {
        List<Course> course = courseService.getCourseByCreatedDate(createdDate);
        return course;

    }
    @RequestMapping(value = "getCourseByUpdatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        List<Course> course = courseService.getCourseByUpdatedDate(updatedDate);
        return course;

    }
}
