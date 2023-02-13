package com.codeline.SpringBootPractice.School.project.Repository;

import com.codeline.SpringBootPractice.School.project.Model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT c from Course c")
    List<Course> getAllCourses();

    @Query(value = "SELECT c from Course c where c.id = :courseId")
    Course getCourseById(@Param("courseId") Integer id);

    @Query(value = "select c from Course c where courseName = :courseName")
    List<Course> getCourseByName(@Param("courseName") String courseName);
    @Query(value = "select c from Course c where c.student.id = :studentId")
    List<Course> getCoursesByStudentId(@Param("studentId")Integer id);

}
