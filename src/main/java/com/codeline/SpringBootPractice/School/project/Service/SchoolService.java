package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools() {

        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id){
        School school=schoolRepository.getSchoolById(id);
        return school;
    }

}