package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.codeline.SpringBootPractice.School.project.Service.ReportService;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    SlackClient slackClient;

    @Autowired
    ReportService reportService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
        return schools;

    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;

    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;

    }

    @RequestMapping(value = "getAllActiveSchools", method = RequestMethod.GET)
    public List<School> getAllActiveSchools() {
        List<School> activeSchools = new ArrayList<>();
        activeSchools = schoolService.getAllActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(activeSchools).toString());
        return activeSchools;
    }

    @RequestMapping(value = "getAllInActiveSchools", method = RequestMethod.GET)
    public List<School> getAllInActiveSchools() {
        List<School> allInActiveSchools = new ArrayList<>();
        allInActiveSchools = schoolService.getAllInActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(allInActiveSchools).toString());
        return allInActiveSchools;
    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getSchoolCreatedAfterDate(createdDate);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
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
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public School getLatestUpdatedDate() {
        School school = schoolService.getLatestUpdatedDate();
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
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
        schoolService.deleteSchoolsByCreatedDate(createdDate);
    }

    @RequestMapping(value = "deleteSchoolsByUpdatedDate", method = RequestMethod.POST)
    public void deleteSchoolsByUpdatedDate(@RequestParam String updatedDate) {
        schoolService.deleteSchoolsByUpdatedDate(updatedDate);
    }

    @RequestMapping(value = "getSchoolsByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolsByCreatedDate(String createdDate) throws ParseException {
        List<School> schools = schoolService.getSchoolsByCreatedDate(createdDate);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
        return schools;
    }

    @RequestMapping(value = "getSchoolsByUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolsByUpdatedDate(String updatedDate) throws ParseException {
        List<School> schools = schoolService.getSchoolsByUpdatedDate(updatedDate);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
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

    @RequestMapping(value = "getSchoolByNumberOfStudents", method = RequestMethod.GET)
    public List<School> getSchoolByNumberOfStudents(@RequestParam Integer numberOFStudents) {
        List<School> schoolList = schoolService.getSchoolByNumberOfStudent(numberOFStudents);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schoolList).toString());
        return schoolList;
    }

    @RequestMapping(value = "TestingReports")
    public String generateReports() throws FileNotFoundException, JRException {
        return reportService.generateTestingReport();
    }
    @RequestMapping(value = "SchoolReports")
    public String generateSchoolReports() throws FileNotFoundException, JRException {
        return reportService.generateSchoolReport();
    }
}
