package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
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
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;

    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;

    }

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        return school;

    }
    @RequestMapping(value = "getAllActiveSchools", method = RequestMethod.GET)
    public List<School> getAllActiveSchools(){
        List<School> activeSchools = new ArrayList<>();
        activeSchools = schoolService.getAllActiveSchools();
        return activeSchools;
    }

    @RequestMapping(value = "getAllInActiveSchools", method = RequestMethod.GET)
    public List<School> getAllInActiveSchools(){
        List<School> allInActiveSchools = new ArrayList<>();
        allInActiveSchools = schoolService.getAllInActiveSchools();
        return allInActiveSchools;
    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(){
        List<School> schools = new ArrayList<>();
        schools = schoolService.getSchoolCreatedAfterDate();
        return schools;
    }
    public void updateCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.updateCreatedDateByUserInput(data.getDate(), data.getId());
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public void createSchool(@RequestParam String schoolName){
        schoolService.createSchool(schoolName);
    }
    @RequestMapping(value = "getLatestRow",method = RequestMethod.GET)
    public School getLatestRow(){
        School school=schoolService.getLatestRow();
        return school;
    }
}
