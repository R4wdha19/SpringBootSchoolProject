package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SchoolControllerTest {
@Autowired
SchoolController schoolController;
    @Test
    void getAllSchools() {
        List<School> schoolsList = schoolController.getAllSchools();
        Integer sizeOfList = schoolsList.size();
        assertNotEquals(0, sizeOfList);
        assertNotNull(schoolsList);

    }

    @Test
    void getSchoolById() {
    }

    @Test
    void getSchoolByName() {
    }

    @Test
    void getAllActiveSchools() {
    }

    @Test
    void getAllInActiveSchools() {
    }

    @Test
    void getSchoolCreatedAfterDate() {
    }

    @Test
    void updateCreatedDateByUserInput() {
    }

    @Test
    void createSchool() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void getLatestUpdatedDate() {
    }

    @Test
    void deleteSchoolById() {
    }

    @Test
    void deleteAllSchools() {
    }

    @Test
    void deleteSchoolByName() {
    }

    @Test
    void deleteSchoolsByCreatedDate() {
    }

    @Test
    void deleteSchoolsByUpdatedDate() {
    }

    @Test
    void getSchoolsByCreatedDate() {
    }

    @Test
    void getSchoolsByUpdatedDate() {
    }

    @Test
    void updateSchool() {
    }

    @Test
    void deleteAllSchoolsCreatedAfterDate() {
    }

    @Test
    void getSchoolByNumberOfStudents() {
    }
}