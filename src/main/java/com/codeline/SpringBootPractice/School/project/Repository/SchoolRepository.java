package com.codeline.SpringBootPractice.School.project.Repository;


import com.codeline.SpringBootPractice.School.project.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface SchoolRepository extends JpaRepository<School, Integer> {

        @Query(value = "SELECT s from School s")
        List<School> getAllSchools();


    }

