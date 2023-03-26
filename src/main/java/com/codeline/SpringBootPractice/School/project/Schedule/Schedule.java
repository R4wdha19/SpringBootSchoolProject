package com.codeline.SpringBootPractice.School.project.Schedule;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.CourseService;
import com.codeline.SpringBootPractice.School.project.Service.MarkService;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import com.codeline.SpringBootPractice.School.project.Service.StudentService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component

public class Schedule {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;
    @Autowired
    MarkService markService;
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;

    @Scheduled(cron = "0 0/15 * * * *")
    public void getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "0 0/16 * * * *")
    public void getSchoolById() {
        School school = schoolService.getSchoolById(1);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }

    @Scheduled(cron = "0 0/17 * * * *")
    public void getSchoolByName() {
        School school = schoolService.getSchoolByName("AlTqwa");
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }

    @Scheduled(cron = "0 0/18 * * * *")
    public void getAllActiveSchools() {
        List<School> schools = schoolService.getAllActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "0 0/19 * * * *")
    public void getAllInActiveSchools() {
        List<School> schools = schoolService.getAllInActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void getSchoolCreatedAfterDate() throws ParseException {
        List<School> schools = schoolService.getSchoolCreatedAfterDate("2022-02-25");
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "0 0/21 * * * *")
    public void getLatestRow() {
        School school = schoolService.getLatestRow();
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }

    @Scheduled(cron = "0 0/22 * * * *")
    public void getLatestUpdatedDate() {
        School school = schoolService.getLatestUpdatedDate();
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }
         // Scheduling Courses APIs
    @Scheduled(cron = "0 0/23 * * * *")
    public void getAllCourses() {
       List<Course> course = courseService.getAllCourses();
        slackClient.sendMessage(courseService.formatCourseListForSlack(course).toString());
    }
    @Scheduled(cron = "0 0/24 * * * *")
    public void getCourseById() {
        Course course = courseService.getCourseById(2);
        slackClient.sendMessage(courseService.formatCourseObjectForSlack(course).toString());
    }
    @Scheduled(cron = "0 0/25 * * * *")
    public void getCourseByName() {
        List<Course> course = courseService.getCoursesByName("Math");
        slackClient.sendMessage(courseService.formatCourseListForSlack(course).toString());
    }

    @Scheduled(cron = "0 0/26 * * * *")
    public void getAllActiveCourses() {
        List<Course> course = courseService.getAllActiveCourses();
        slackClient.sendMessage(courseService.formatCourseListForSlack(course).toString());
    }

    @Scheduled(cron = "0 0/27 * * * *")
    public void getAllInActiveCourses() {
        List<Course> course = courseService.getAllInActiveCourses();
        slackClient.sendMessage(courseService.formatCourseListForSlack(course).toString());
    }
    @Scheduled(cron = "0 0/28 * * * *")
    public void getCourseCreatedAfterDate() throws ParseException {
        List<Course> course = courseService.getCoursesCreatedAfterDate("2022-02-25");
        slackClient.sendMessage(courseService.formatCourseListForSlack(course).toString());
    }

    @Scheduled(cron = "0 0/29 * * * *")
    public void getCourseLatestUpdatedDate() {
        Course course = courseService.getLatestUpdatedDate();
        slackClient.sendMessage(courseService.formatCourseObjectForSlack(course).toString());
    }

      // Scheduling Mark APIs

    @Scheduled(cron = "0 0/30 * * * *")
    public void getAllMarks() {
        List<Mark> markList = markService.getAllMarks();
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }

    @Scheduled(cron = "0 0/31 * * * *")
    public void getMarkById() {
        Mark mark = markService.getMarkById(2);
        slackClient.sendMessage(markService.formatMarkObjectForSlack(mark).toString());
    }

    @Scheduled(cron = "0 0/32 * * * *")
    public void getMarkByGrade() {
        List<Mark> mark = markService.getMarkByGrade("A");
        slackClient.sendMessage(markService.formatMarkListForSlack(mark).toString());
    }
    @Scheduled(cron = "0 0/33 * * * *")
    public void getAllActiveMarks() {
        List<Mark> markList = markService.getAllActiveMarks();
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }

    @Scheduled(cron = "0 0/34 * * * *")
    public void getAllInActiveMarks() {
        List<Mark> markList = markService.getAllInActiveMarks();
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }

    @Scheduled(cron = "0 0/35 * * * *")
    public void getMarkLatestRow() {
        Mark mark = markService.getLatestRow();
        slackClient.sendMessage(markService.formatMarkObjectForSlack(mark).toString());
    }

    @Scheduled(cron = "0 0/36 * * * *")
    public void getMarkCreatedAfterDate() throws ParseException {
        List<Mark> markList = markService.getMarkCreatedAfterDate("2022-02-25");
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }

    @Scheduled(cron = "0 0/37 * * * *")
    public void getMarkLatestUpdatedDate() {
        List<Mark> markList = markService.getMarksByUpdatedDate("2022-02-25");
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }
    @Scheduled(cron = "0 0/38 * * * *")
    public void getByObtainedMarksMoreThan() {
        List<Mark> markList = markService.getByObtainedMarksMoreThan(90);
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }

    @Scheduled(cron = "0 0/39 * * * *")
    public void getByObtainedMarksLessThan() {
        List<Mark> markList = markService.getByObtainedMarksLessThan(50);
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }

    @Scheduled(cron = "0 0/40 * * * *")
    public void getMarksByCourseId() {
        List<Mark> markList = markService.getMarksByCourseId(2);
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
    }

    // Scheduling Student APIs

    @Scheduled(cron = "0 0/30 * * * *")
    public void getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        slackClient.sendMessage(studentService.formatStudentListForSlack(studentList).toString());
    }
    @Scheduled(cron = "0 0/30 * * * *")
    public void getStudentById() {
        Student student = studentService.getStudentById(3);
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
    }

    @Scheduled(cron = "0 0/30 * * * *")
    public void getStudentByStudentName() {
        Student student = studentService.getStudentByStudentName("Shim");
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
    }

    @Scheduled(cron = "0 0/30 * * * *")
    public void getAllActiveStudents() {
        List<Student> studentList = studentService.getAllActiveStudents();
        slackClient.sendMessage(studentService.formatStudentListForSlack(studentList).toString());
    }

    @Scheduled(cron = "0 0/30 * * * *")
    public void getAllInActiveStudents() {
        List<Student> studentList = studentService.getAllInActiveStudents();
        slackClient.sendMessage(studentService.formatStudentListForSlack(studentList).toString());
    }
    @Scheduled(cron = "0 0/30 * * * *")
    public void getStudentCreatedAfterDate() {
        List<Student> studentList = studentService.getStudentCreatedAfterDate();
        slackClient.sendMessage(studentService.formatStudentListForSlack(studentList).toString());
    }
    @Scheduled(cron = "0 0/30 * * * *")
    public void getStudentsLatestRow() {
        Student student = studentService.getLatestRow();
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
    }
    @Scheduled(cron = "0 0/30 * * * *")
    public void  getStudentsByUpdatedDate() {
        List<Student> studentsByUpdatedDate = studentService.getStudentsByUpdatedDate("2022-02-25");
        slackClient.sendMessage(studentService.formatStudentListForSlack(studentsByUpdatedDate).toString());
    }
    @Scheduled(cron = "0 0/30 * * * *")
    public void  studentLatestUpdatedDate() {
        Student student = studentService.getLatestUpdatedDate();
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
    }
    @Scheduled(cron = "0 0/30 * * * *")
    public void   getStudentsByCreatedDate() {
        List<Student> studentsByCreatedDate = studentService.getStudentsByCreatedDate("2022-02-25");
        slackClient.sendMessage(studentService.formatStudentListForSlack(studentsByCreatedDate).toString());
    }
    @Scheduled(cron = "0 0/30 * * * *")
    public void getByStudentByRollNumber() {
        Student student = studentService.getByStudentByRollNumber(3);
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
    }





}
