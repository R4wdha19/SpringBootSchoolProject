package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import com.codeline.SpringBootPractice.School.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;

    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;

    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        return school;

    }

    @RequestMapping(value = "getAllActiveSchools", method = RequestMethod.GET)
    public List<School> getAllActiveSchools() {
        List<School> activeSchools = new ArrayList<>();
        activeSchools = schoolService.getAllActiveSchools();
        return activeSchools;
    }

    @RequestMapping(value = "getAllInActiveSchools", method = RequestMethod.GET)
    public List<School> getAllInActiveSchools() {
        List<School> allInActiveSchools = new ArrayList<>();
        allInActiveSchools = schoolService.getAllInActiveSchools();
        return allInActiveSchools;
    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getSchoolCreatedAfterDate(createdDate);
        return schools;
    }

    public void updateCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.updateCreatedDateByUserInput(data.getDate(), data.getId());
    }

    @RequestMapping(value = "createSchool", method = RequestMethod.POST)
    public void createSchool(@RequestParam String schoolName) {
        schoolService.createSchool(schoolName);
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public School getLatestRow() {
        School school = schoolService.getLatestRow();
        return school;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public School getLatestUpdatedDate() {
        School school = schoolService.getLatestUpdatedDate();
        return school;
    }

    @RequestMapping(value = "deleteSchoolById", method = RequestMethod.POST)
    public void deleteSchoolById(@RequestParam Integer schoolId) {
        schoolService.deleteSchoolById(schoolId);
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAllSchools() {
        schoolService.deleteAllSchool();
    }

    @RequestMapping(value = "deleteSchoolByName", method = RequestMethod.POST)
    public void deleteSchoolByName(@RequestParam String schoolName) {
        schoolService.deleteSchoolByName(schoolName);
    }

    @RequestMapping(value = "deleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public void deleteSchoolsByCreatedDate(@RequestParam String createdDate) {
        schoolService.deleteCoursesByCreatedDate(createdDate);
    }

    @RequestMapping(value = "deleteSchoolsByUpdatedDate", method = RequestMethod.POST)
    public void deleteSchoolsByUpdatedDate(@RequestParam String updatedDate) {
        schoolService.deleteCoursesByUpdatedDate(updatedDate);
    }

    @RequestMapping(value = "getSchoolsByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolsByCreatedDate(String createdDate) throws ParseException {
        List<School> schools = schoolService.getSchoolsByCreatedDate(createdDate);
        return schools;
    }

    @RequestMapping(value = "getSchoolsByUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolsByUpdatedDate(String updatedDate) throws ParseException {
        List<School> schools = schoolService.getSchoolsByUpdatedDate(updatedDate);
        return schools;
    }

    @RequestMapping(value = "updateSchool", method = RequestMethod.POST)
    public void updateSchool(@RequestParam Integer schoolId, String schoolName, Boolean isActive) {
        schoolService.updateSchool(schoolId, schoolName, isActive);
    }

    @RequestMapping(value = "deleteAllSchoolsCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllSchoolsCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        schoolService.deleteAllSchoolsCreatedAfterDate(createdDate);
    }

 /*   public School getSchoolByNumberOfStudents(@RequestParam Integer numberOFStudents, Integer schoolId) {
        studentService.getStudentsBySchoolId(schoolId);

    }*/
}
