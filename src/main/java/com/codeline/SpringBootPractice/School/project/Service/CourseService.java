package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {


    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentService studentService;

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(Integer id) {
        Course course = courseRepository.getCourseById(id);
        return course;
    }

    public List<Course> getCourseByName(String courseName) {
        List<Course> course = courseRepository.getCourseByName(courseName);
        return course;
    }

    public List<Course> getCoursesByStudentName(String studentName) {
        Student student = studentService.getStudentByStudentName(studentName);
        Integer studentId = student.getId();
        List<Course> courseList = courseRepository.getCoursesByStudentId(studentId);
        return courseList;
    }

    public List<Course> getAllActiveCourses() {
        List<Course> allActiveCourses = courseRepository.getAllActiveCourses();
        return allActiveCourses;
    }

    public List<Course> getAllInActiveCourses() {
        List<Course> allInActiveCourses = courseRepository.getAllInActiveCourses();
        return allInActiveCourses;
    }

    public List<Course> getCourseCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date usableDate = dateFormatter.parse(createdDate);
        List<Course> courses = courseRepository.getCourseCreatedAfterDate(usableDate);
        return courses;
    }

    public Course getLatestRow() {
        Course course = courseRepository.getLatestRow();
        return course;
    }

    public Course getLatestUpdatedDate() {
        Course course = courseRepository.getLatestUpdatedDate();
        return course;
    }

    public void deleteCourseById(Integer courseId) {
        Course course = courseRepository.getCourseById(courseId);
        course.setIsActive(false);
        courseRepository.save(course);
    }

    public void deleteAllCourses() {
        courseRepository.deleteAllCourses();
    }

    public void deleteCourseByName(String courseName) {
        List<Course> course = courseRepository.getCourseByName(courseName);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }

    public void createCourse(String courseName, Integer studentId) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setStudent(studentService.getStudentById(studentId));
        course.setIsActive(true);
        course.setCreatedDate(new Date());
        courseRepository.save(course);
    }
    public List<Course> getCourseByCreatedDate(String createdDate) throws ParseException {
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date usableDate = dateFormatter.parse(createdDate);
        List<Course> course = courseRepository.getCourseByCreatedDate(createdDate);
        return course;
    }

    public List<Course> getCourseByUpdatedDate(String updatedDate) throws ParseException {
        List<Course> course = courseRepository.getCourseByUpdatedDate(updatedDate);
        return course;
    }
}
