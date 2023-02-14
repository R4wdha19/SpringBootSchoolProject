package com.codeline.SpringBootPractice.School.project.Repository;
import com.codeline.SpringBootPractice.School.project.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query(value = "SELECT s from School s")// this is a function declaration
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id = :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);


    @Query(value = "select s from School s where s.schoolName = :schoolName")
    School getSchoolByName(@Param("schoolName")String schoolName);

    @Query(value = "select s from School s where s.isActive = 1")
    List<School> getAllActiveSchools();
}

