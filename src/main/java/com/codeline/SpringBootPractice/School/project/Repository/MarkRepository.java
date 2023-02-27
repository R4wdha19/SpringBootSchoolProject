package com.codeline.SpringBootPractice.School.project.Repository;
import com.codeline.SpringBootPractice.School.project.Model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {

    @Query(value = "SELECT m from Mark m")
    List<Mark> getAllMarks();

    @Query(value = "SELECT m from Mark m where m.id = :markId")
    Mark getMarkById(@Param("markId") Integer id);
    @Query("select m from Mark m where m.grade = :grade")
    List<Mark>  getMarkByGrade(@Param("grade")String grade);

    @Query(value = "select m from Mark m where m.isActive = 1")
    List<Mark> getAllActiveMarks();

    @Query(value = "select m from Mark m where m.isActive = 0")
    List<Mark> getAllInActiveMarks();

    @Query(value = "select m from Mark m where m.createdDate >= :createdDate")
    List<Mark> getMarkCreatedAfterDate(@Param("createdDate")String createdDate);

}