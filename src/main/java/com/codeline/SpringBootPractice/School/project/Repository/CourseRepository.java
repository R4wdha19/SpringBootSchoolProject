package com.codeline.SpringBootPractice.School.project.Repository;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT c from Course c")
    List<Course> getAllCourses();

    @Query(value = "SELECT c from Course c where c.id = :courseId")
    Course getCourseById(@Param("courseId") Integer id);

    @Query(value = "select c from Course c where c.courseName = :courseName")
    List<Course> getCourseByName(@Param("courseName") String courseName);

    @Query(value = "select c from Course c where c.student.id = :studentId")
    List<Course> getCoursesByStudentId(@Param("studentId") Integer id);

    @Query(value = "select c from Course c where c.isActive = 1")
    List<Course> getAllActiveCourses();

    @Query(value = "select c from Course c where c.isActive = 0")
    List<Course> getAllInActiveCourses();

    @Query(value = "select c from Course c where c.createdDate >= '2022-02-25'")
    List<Course> getCourseCreatedAfterDate();

    @Query(value = "select c from Course c where c.id = (select Max(c.id) from Course c )")
    Course getLatestRow();

    @Query(value = " select c from Course c where c.updatedDate = (select Max(c.updatedDate) from Course c)")
    Course getLatestUpdatedDate();

    @Modifying
    @Transactional
    @Query(value = "update Course c Set c.isActive = false")
    void deleteAllCourses();

/*    @Query(value = " select c from Course c where c.courseName = :courseName")
    List<Mark> getMarksByCourseName(@Param("courseName")String courseName);*/
}
