package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}