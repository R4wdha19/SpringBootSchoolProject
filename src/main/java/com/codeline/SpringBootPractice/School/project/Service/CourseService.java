package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }
}
