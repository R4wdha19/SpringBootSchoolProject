package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Student student= studentService.getStudentByStudentName(studentName);
        Integer studentId = student.getId();
        List<Course> courseList = courseRepository.getCoursesByStudentId(studentId);
        return courseList;
    }

    public List<Course> getAllActiveCourses(){
        List<Course> allActiveCourses = courseRepository.getAllActiveCourses();
        return allActiveCourses;
    }

    public List<Course> getAllInActiveCourses(){
        List<Course> allInActiveCourses = courseRepository.getAllInActiveCourses();
        return allInActiveCourses;
    }

    public List<Course> getCourseCreatedAfterDate(){
        List<Course> courses = courseRepository.getCourseCreatedAfterDate();
        return courses;
    }

}
