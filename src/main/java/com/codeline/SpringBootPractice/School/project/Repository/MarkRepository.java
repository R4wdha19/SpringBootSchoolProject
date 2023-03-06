package com.codeline.SpringBootPractice.School.project.Repository;

import com.codeline.SpringBootPractice.School.project.Model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {

    @Query(value = "SELECT m from Mark m")
    List<Mark> getAllMarks();

    @Query(value = "SELECT m from Mark m where m.id = :markId")
    Mark getMarkById(@Param("markId") Integer id);

    @Query("select m from Mark m where m.grade = :grade")
    List<Mark> getMarkByGrade(@Param("grade") String grade);

    @Query(value = "select m from Mark m where m.isActive = 1")
    List<Mark> getAllActiveMarks();

    @Query(value = "select m from Mark m where m.isActive = 0")
    List<Mark> getAllInActiveMarks();

    @Query(value = "select * from Mark where created_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Mark> getMarkByCreatedDate(@Param("createdDate") String createdDate);

    @Query(value = "select m from Mark m where m.createdDate >= :createdDate")
    List<Mark> getMarkCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "select m from Mark m where m.id = (select Max(m.id) from Mark m)")
    Mark getLatestRow();

    @Query(value = " select m from Mark m where m.updatedDate = (select Max(m.updatedDate) from Mark m)")
    Mark getLatestUpdatedDate();


    @Query(value = "select m from Mark m where m.obtainedMarks > :obtainedMarks")
    List<Mark> getByObtainedMarksMoreThan(@Param("obtainedMarks") Integer obtainedMarks);

    @Query(value = "select m from Mark m where m.obtainedMarks < :obtainedMarks")
    List<Mark> getByObtainedMarksLessThan(@Param("obtainedMarks") Integer obtainedMarks);

    @Query(value = "select * from Mark where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Mark> getMarksByUpdatedDate(@Param("updatedDate") String updatedDate);

    @Query("select m from Mark m where m.course.id = :courseId")
    List<Mark> getMarksByCourseId(@Param("courseId") Integer courseId);

    @Modifying
    @Transactional
    @Query(value = "update Mark m Set m.isActive = false")
    void deleteAllMarks();

}