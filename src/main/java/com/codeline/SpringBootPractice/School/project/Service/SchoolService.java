package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools() {

        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    public School getSchoolByName(String schoolName) {
        School school = schoolRepository.getSchoolByName(schoolName);
        return school;
    }

    public List<School> getAllActiveSchools() {
        List<School> allActiveSchools = schoolRepository.getAllActiveSchools();
        return allActiveSchools;
    }

    public List<School> getAllInActiveSchools() {
        List<School> allInActiveSchools = schoolRepository.getAllInActiveSchools();
        return allInActiveSchools;
    }

    public List<School> getSchoolCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date usableDate = dateFormatter.parse(createdDate);
        List<School> schools = schoolRepository.getSchoolCreatedAfterDate(usableDate);
        return schools;

    }

    public void updateCreatedDateByUserInput(String Date, Integer id) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date usableDate = dateFormatter.parse(Date);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(usableDate);
        schoolRepository.save(school);
    }

    public void createSchool(String schoolName) {
        School school = new School();
        school.setSchoolName(schoolName);
        school.setCreatedDate(new Date());
        school.setIsActive(Boolean.TRUE);
        schoolRepository.save(school);
    }

    public School getLatestRow() {
        School school = schoolRepository.getLatestRow();
        return school;
    }

    public School getLatestUpdatedDate() {
        School school = schoolRepository.getLatestUpdatedDate();
        return school;
    }

    public void deleteSchoolById(Integer schoolId) {
        School school = schoolRepository.getSchoolById(schoolId);
        school.setIsActive(false);
        schoolRepository.save(school);
    }

    public void deleteAllSchool() {
        schoolRepository.deleteAllSchoolsByIsActiveFalse();
    }
    public void deleteSchoolByName(String schoolName) {
        School school = schoolRepository.getSchoolByName(schoolName);
        school.setIsActive(false);
        schoolRepository.save(school);
    }

    public  List<School> getSchoolsByCreatedDate(String createdDate){
        List<School> schools=schoolRepository.getSchoolsByCreatedDate(createdDate);
        return schools;
    }

    public  List<School> getSchoolsByUpdatedDate(String updatedDate){
        List<School> schools=schoolRepository.getSchoolsByUpdatedDate(updatedDate);
        return schools;
    }

    public void deleteCoursesByCreatedDate(String createdDate) {
        List<School> schoolList = schoolRepository.getSchoolsByCreatedDate(createdDate);
        schoolList.stream().forEach(x -> x.setIsActive(false));
        schoolRepository.saveAll(schoolList);
    }
    public void deleteCoursesByUpdatedDate(String updatedDate) {
        List<School> schools = schoolRepository.getSchoolsByUpdatedDate(updatedDate);
        schools.stream().forEach(x -> x.setIsActive(false));
        schoolRepository.saveAll(schools);
    }
    public void updateSchool(Integer schoolId,String schoolName,Boolean isActive){
        School school =schoolRepository.getSchoolById(schoolId);
        school.setSchoolName(schoolName);
        school.setCreatedDate(new Date());
        school.setIsActive(isActive);
        schoolRepository.save(school);
    }
    public void deleteAllSchoolsCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate=dateFormat.parse(createdDate);
        List<School> schoolList=schoolRepository.getSchoolCreatedAfterDate(formatedDate);
        schoolList.stream().forEach(r->r.setIsActive(false));
        schoolRepository.saveAll(schoolList);

    }

    public School getSchoolByNumberOfStudents(Integer numberOfStudents){

    }

}