package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
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
        assertNotEquals(0, listSize);
    }

    @Test
    void testingTheStudentIdFromGetCourseById() throws Exception {
        Course courseById = courseController.getCourseById(1);
        Integer studentId = courseById.getStudent().getId();
        assertEquals(2, studentId);
    }

    @Test
    void testingTheCourseNameFromGetCourseById() throws Exception {
        Course courseById = courseController.getCourseById(1);
        String courseName = courseById.getCourseName();
        assertEquals("Kinder", courseName);
    }

    @Test
    void testingTheStatusFromGetCourseById() throws Exception {
        Course courseById = courseController.getCourseById(1);
        Boolean status = courseById.getIsActive();
        assertTrue(status);
    }

    @Test
    void testingTheUpdatedDateFromGetCourseById() throws Exception {
        Course courseById = courseController.getCourseById(1);
        Date updatedDate = courseById.getUpdatedDate();
        assertEquals("2023-03-05 14:34:03.561", updatedDate.toString());
    }

    @Test
    void testingSizeOfCoursesListFormGetCourseByName() {
        List<Course> coursesByName = courseController.getCourseByName("English");
        Integer listSize = coursesByName.size();
        assertNotEquals(0, listSize);
    }

    @Test
    void testingGettingTheCorrectNameFormGetCourseByName() {
        List<Course> coursesByName = courseController.getCourseByName("English");
        String courseName = coursesByName.get(0).getCourseName();
        assertEquals("English", courseName);
    }

    @Test
    void testingCreatedDateIsNotNullFormGetCourseByName() {
        List<Course> coursesByName = courseController.getCourseByName("English");
        Date createdDate = coursesByName.get(0).getCreatedDate();
        assertNotNull(createdDate);
    }

    @Test
    void testingGettingTheCorrectNumberOfCourseFormGetCourseByName() {
        List<Course> coursesByName = courseController.getCourseByName("English");
        Integer listSize = coursesByName.size();
        assertEquals(3, listSize);
    }

    @Test
    void testingSizeOfAllActiveCourses() {
        List<Course> allActiveCourses = courseController.getAllActiveCourses();
        Integer sizeOfActiveCoursesList = allActiveCourses.size();
        assertNotNull(sizeOfActiveCoursesList);
    }

    @Test
    void testingGettingAllActiveCourses() {
        List<Course> allActiveCourses = courseController.getAllActiveCourses();
        Boolean status = allActiveCourses.get(4).getIsActive();
        assertTrue(status);
    }

    @Test
    void testingGettingAllInActiveCourses() {
        List<Course> allInActiveCourses = courseController.getAllInActiveCourses();
        Boolean status = allInActiveCourses.get(2).getIsActive();
        assertFalse(status);
    }

    @Test
    void testingTheListSizeAllInActiveCourses() {
        List<Course> allInActiveCourses = courseController.getAllInActiveCourses();
        Integer sizeOfInActiveCoursesList = allInActiveCourses.size();
        assertNotNull(sizeOfInActiveCoursesList);
    }

    @Test
    void getCourseCreatedAfterDate() throws ParseException {
        List<Course> courseList = courseController.getCourseCreatedAfterDate("2023-03-05");
        assertEquals(2, courseList.size());
    }

    @Test
    void testingGetLatestRow() {
        Course latestCourseRow = courseController.getLatestRow();
        assertNotNull(latestCourseRow);
    }

    @Test
    void testingGetLatestUpdatedDate() {
        Course latestUpdatedDateRow = courseController.getLatestUpdatedDate();
        assertNotNull(latestUpdatedDateRow);
    }

    @Test
    void getCourseByCreatedDate() {
        List<Course> coursesList = courseController.getCourseByCreatedDate("2022-02-23 11:59:42.6533333");
        Date createdDate = coursesList.get(0).getCreatedDate();
        assertEquals("2022-02-23 11:59:42.6533333",createdDate.toString());
    }

    @Test
    void getCourseByUpdatedDate() {
        List<Course> coursesList = courseController.getCourseByUpdatedDate("2022-03-01 14:59:37.0500000");
        Date updatedDate = coursesList.get(0).getUpdatedDate();
        assertEquals("2022-03-01 14:59:37.05",updatedDate.toString());
    }

    @Test
    void getCourseByStudentId() {
        List<Course> studentCoursesList = courseController .getCourseByStudentId(3);
        Integer studentId = studentCoursesList.get(0).getStudent().getId();
        assertEquals(3,studentId);
    }

    @Test
    void getAllActiveCoursesForAStudent() {
        List<Course> studentActiveCoursesList = courseController.getAllActiveCoursesForAStudent(3);
        assertNotNull(studentActiveCoursesList);
    }

    @Test
    void testingSizeOfAllActiveCoursesForAStudent() {
        List<Course> studentActiveCoursesList = courseController.getAllActiveCoursesForAStudent(3);
        assertEquals(3,studentActiveCoursesList.size());
    }

}