package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {
    @Autowired
    CourseController courseController;

    @Test
    void getAllCoursesTest() throws Exception {
        List<Course> listOfAllCoursesTest = courseController.getAllCourses();
        Integer listSize = listOfAllCoursesTest.size();
        assertNotEquals(0,listSize);
    }

    @Test
    void getCourseByIdTest() {
        Course courseById= courseController.getCourseById(1);
        Integer studentId = courseById.getStudent().getId();
        assertEquals(2,studentId);
    }

    @Test
    void getCourseByName() {
    }

    @Test
    void getAllActiveCourses() {
    }

    @Test
    void getAllInActiveCourses() {
    }

    @Test
    void getCourseCreatedAfterDate() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void getLatestUpdatedDate() {
    }

    @Test
    void createCourse() {
    }

    @Test
    void getCourseByCreatedDate() {
    }

    @Test
    void getCourseByUpdatedDate() {
    }

    @Test
    void getCourseByStudentId() {
    }

    @Test
    void getAllActiveCoursesForAStudent() {
    }

    @Test
    void deleteCourseById() {
    }

    @Test
    void deleteAllCourses() {
    }

    @Test
    void deleteCourseByName() {
    }

    @Test
    void deleteCoursesByCreatedDate() {
    }

    @Test
    void deleteCoursesByUpdatedDate() {
    }

    @Test
    void deleteAllCoursesCreatedAfterDate() {
    }

    @Test
    void updateCourse() {
    }
}