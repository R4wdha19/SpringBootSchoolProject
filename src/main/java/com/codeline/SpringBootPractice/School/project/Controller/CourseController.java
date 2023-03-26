package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Service.CourseService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
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
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses = courseService.getAllCourses();
        slackClient.sendMessage(courseService.formatCourseListForSlack(courses).toString());
        return courses;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        slackClient.sendMessage(courseService.formatCourseObjectForSlack(course).toString());
        return course;

    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    public List<Course> getCourseByName(@RequestParam String courseName) {
        List<Course> coursesByName = courseService.getCoursesByName(courseName);
        slackClient.sendMessage(courseService.formatCourseListForSlack(coursesByName).toString());
        return coursesByName;
    }

    @RequestMapping(value = "getAllActiveCourses", method = RequestMethod.GET)
    public List<Course> getAllActiveCourses() {
        List<Course> activeCourseList = new ArrayList<>();
        activeCourseList = courseService.getAllActiveCourses();
        slackClient.sendMessage(courseService.formatCourseListForSlack(activeCourseList).toString());
        return activeCourseList;
    }

    @RequestMapping(value = "getAllInActiveCourses", method = RequestMethod.GET)
    public List<Course> getAllInActiveCourses() {
        List<Course> inActiveCourseList = new ArrayList<>();
        inActiveCourseList = courseService.getAllInActiveCourses();
        slackClient.sendMessage(courseService.formatCourseListForSlack(inActiveCourseList).toString());
        return inActiveCourseList;
    }

    @RequestMapping(value = "getCourseCreatedAfterDate", method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Course> courseList = new ArrayList<>();
        courseList = courseService.getCoursesCreatedAfterDate(createdDate);
        slackClient.sendMessage(courseService.formatCourseListForSlack(courseList).toString());
        return courseList;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Course getLatestRow() {
        Course courseLatestRow = courseService.getLatestRow();
        slackClient.sendMessage(courseService.formatCourseObjectForSlack(courseLatestRow).toString());
        return courseLatestRow;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public Course getLatestUpdatedDate() {
        Course courseLatestUpdatedDate = courseService.getLatestUpdatedDate();
        slackClient.sendMessage(courseService.formatCourseObjectForSlack(courseLatestUpdatedDate).toString());
        return courseLatestUpdatedDate;
    }

    @RequestMapping(value = "createCourse", method = RequestMethod.POST)
    public void createCourse(@RequestParam String courseName, Integer studentId) {
        courseService.createCourse(courseName, studentId);
    }

    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByCreatedDate(@RequestParam String createdDate)  {
        List<Course> coursesByCreatedDate = courseService.getCoursesByCreatedDate(createdDate);
        slackClient.sendMessage(courseService.formatCourseListForSlack(coursesByCreatedDate).toString());
        return coursesByCreatedDate;

    }

    @RequestMapping(value = "getCourseByUpdatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByUpdatedDate(@RequestParam String updatedDate)  {
        List<Course> coursesByUpdatedDate = courseService.getCoursesByUpdatedDate(updatedDate);
        slackClient.sendMessage(courseService.formatCourseListForSlack(coursesByUpdatedDate).toString());
        return coursesByUpdatedDate;

    }

    @RequestMapping(value = "getCourseByStudentId", method = RequestMethod.GET)
    public List<Course> getCourseByStudentId(@RequestParam Integer studentId) {
        List<Course> coursesOfAStudent = courseService.getCoursesByStudentId(studentId);
        slackClient.sendMessage(courseService.formatCourseListForSlack(coursesOfAStudent).toString());
        return coursesOfAStudent;
    }
    @RequestMapping(value = "getAllActiveCoursesForAStudent", method = RequestMethod.GET)
    public List<Course> getAllActiveCoursesForAStudent(@RequestParam Integer studentId) {
        List<Course> AllActiveCoursesForAStudent = courseService.getCoursesByStudentId(studentId);
        slackClient.sendMessage(courseService.formatCourseListForSlack(AllActiveCoursesForAStudent).toString());
        return AllActiveCoursesForAStudent;
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
        courseService.deleteCoursesByName(courseName);
    }

    @RequestMapping(value = "deleteCoursesByCreatedDate", method = RequestMethod.POST)
    public void deleteCoursesByCreatedDate(@RequestParam String createdDate){
        courseService.deleteCoursesByCreatedDate(createdDate);
    }
    @RequestMapping(value = "deleteCoursesByUpdatedDate", method = RequestMethod.POST)
    public void deleteCoursesByUpdatedDate(@RequestParam String updatedDate){
        courseService.deleteCoursesByUpdatedDate(updatedDate);
    }
    @RequestMapping(value = "deleteAllCoursesCreatedAfterDate", method = RequestMethod.POST)
    public String deleteAllCoursesCreatedAfterDate(@RequestParam String createdDate)  {
        try {
            courseService.deleteAllCoursesCreatedAfterDate(createdDate);
        } catch (ParseException e) {
            return "Failed";
        }
        return "Success";
    }
@RequestMapping(value = "updateCourse",method = RequestMethod.POST)
    public void updateCourse(@RequestParam Integer courseId,String courseName,Integer studentId,Boolean isActive){
       courseService.updateCourse(courseId,courseName,studentId,isActive);
    }


}
