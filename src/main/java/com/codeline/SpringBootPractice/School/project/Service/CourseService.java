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

    public List<Course> getCoursesByName(String courseName) {
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

    public List<Course> getCoursesCreatedAfterDate(String createdDate) throws ParseException {
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

    public void deleteCoursesByName(String courseName) {
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

    public List<Course> getCoursesByCreatedDate(String createdDate) {
        List<Course> course = courseRepository.getCourseByCreatedDate(createdDate);
        return course;
    }

    public List<Course> getCoursesByUpdatedDate(String updatedDate) {
        List<Course> course = courseRepository.getCourseByUpdatedDate(updatedDate);
        return course;
    }

    public List<Course> getCoursesByStudentId(Integer studentId) {
        List<Course> coursesOfAStudent = courseRepository.getCoursesByStudentId(studentId);
        return coursesOfAStudent;
    }

    public List<Course> getAllActiveCoursesForAStudent(Integer studentId) {
        List<Course> allActiveCoursesForAStudent = courseRepository.getAllActiveCoursesForAStudent(studentId);
        return allActiveCoursesForAStudent;
    }

    public void deleteCoursesByCreatedDate(String createdDate) {
        List<Course> course = courseRepository.getCourseByCreatedDate(createdDate);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }

    public void deleteCoursesByUpdatedDate(String updatedDate) {
        List<Course> course = courseRepository.getCourseByUpdatedDate(updatedDate);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }

    public void deleteAllCoursesCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date usableDate = dateFormatter.parse(createdDate);
        List<Course> course = courseRepository.deleteAllCoursesCreatedAfterDate(usableDate);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }

    public void updateCourse(Integer courseId, String courseName, Integer studentId, Boolean isActive) {
        Course course = courseRepository.getCourseById(courseId);
        course.setCourseName(courseName);
        course.setIsActive(isActive);
        course.setStudent(studentService.getStudentById(studentId));
        courseRepository.save(course);
    }

    public StringBuilder formatCourseObjectForSlack(Course course){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Id: *" +course.getId() + "*\n");
        stringBuilder.append("Course Is : *"+ course.getCourseName() + "*\n");
        stringBuilder.append("Is Active: *" + course.getIsActive() + "*\n");
        stringBuilder.append("Created Date Is : "+ course.getCreatedDate()+ "*\n");
        stringBuilder.append("Updated Date Is : "+ course.getUpdatedDate()+ "*\n");
        return stringBuilder;
    }

    public StringBuilder formatCourseListForSlack(List<Course> courses){
        StringBuilder stringBuilder = new StringBuilder();
        for (Course courseFromListOfCourses: courses) {
            stringBuilder.append(formatCourseObjectForSlack(courseFromListOfCourses));
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }


}
