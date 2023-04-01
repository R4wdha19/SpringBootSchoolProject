package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {
    @Autowired
    CourseController courseController;

    @Test
    void testingTheCourseListSize() throws Exception {
        List<Course> listOfAllCoursesTest = courseController.getAllCourses();
        Integer listSize = listOfAllCoursesTest.size();
        assertNotEquals(0,listSize);
    }

    @Test
    void testingTheStudentIdFromGetCourseById() throws Exception {
        Course courseById= courseController.getCourseById(1);
        Integer studentId = courseById.getStudent().getId();
        assertEquals(2,studentId);
    }
    @Test
    void testingTheCourseNameFromGetCourseById() throws Exception {
        Course courseById= courseController.getCourseById(1);
        String courseName = courseById.getCourseName();
        assertEquals("Kinder",courseName);
    }
    @Test
    void testingTheStatusFromGetCourseById() throws Exception {
        Course courseById= courseController.getCourseById(1);
        Boolean status = courseById.getIsActive();
        assertTrue(status);
    }
    @Test
    void testingTheUpdatedDateFromGetCourseById() throws Exception {
        Course courseById= courseController.getCourseById(1);
        Date updatedDate = courseById.getUpdatedDate();
        assertEquals("2023-03-05 14:34:03.561",updatedDate.toString());
    }
    @Test
    void testingSizeOfCoursesListFormGetCourseByName() {
        List<Course> coursesByName = courseController .getCourseByName("English");
        Integer listSize = coursesByName.size();
        assertNotEquals(0,listSize);
    }
    @Test
    void testingGettingTheCorrectNameFormGetCourseByName() {
        List<Course> coursesByName = courseController .getCourseByName("English");
        String courseName = coursesByName.get(0).getCourseName();
     assertEquals("English",courseName);
    }
    @Test
    void testingCreatedDateIsNotNullFormGetCourseByName () {
        List<Course> coursesByName = courseController .getCourseByName("English");
        Date createdDate = coursesByName.get(0).getCreatedDate();
        assertNotNull(createdDate);
    }
    @Test
    void testingGettingTheCorrectNumberOfCourseFormGetCourseByName() {
        List<Course> coursesByName = courseController .getCourseByName("English");
        Integer listSize = coursesByName.size();
        assertEquals(3,listSize);
    }
    @Test
    void testingGettingAllActiveCourses() {
        List<Course> allActiveCourses = courseController.getAllActiveCourses();
        Integer sizeOfActiveCoursesList = allActiveCourses.size();
        assertNotNull(sizeOfActiveCoursesList);
    }


    @Test
    void getAllInActiveCourses() {

    }

    @Test
    void getCourseCreatedAfterDate() {

    }

    @Test
    void testingGetLatestRow() {
        Course latestCourseRow = courseController.getLatestRow();
        assertNotNull(latestCourseRow);
    }


    @Test
    void testingGetLatestUpdatedDate() {
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