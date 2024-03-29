package com.codeline.SpringBootPractice.School.project.Repository;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT c from Course c")
    List<Course> getAllCourses();

    @Query(value = "Select c.courseName from Course c")
    List<String> getAllCoursesNames();

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

    @Query(value = "select c from Course c where c.createdDate > :createdDate")
    List<Course> getCourseCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "select c from Course c where c.id = (select Max(c.id) from Course c )")
    Course getLatestRow();

    @Query(value = " select c from Course c where c.updatedDate = (select Max(c.updatedDate) from Course c)")
    Course getLatestUpdatedDate();

    @Query(value = "select c from Course c where c.student.school.id = :schoolId")
    List<Course> getCourseBySchoolId(@Param("schoolId") Integer schoolId);

    @Modifying
    @Transactional
    @Query(value = "update Course c Set c.isActive = false")
    void deleteAllCourses();

    /*getCourseByCreatedDate*/
    @Query(value = "select * from course where created_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Course> getCourseByCreatedDate(String createdDate);

    @Query(value = "select * from course where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Course> getCourseByUpdatedDate(String updatedDate);

    @Query(value = "select c from Course c where c.student.id = :studentId and (c.isActive=1)")
    List<Course> getAllActiveCoursesForAStudent(Integer studentId);

    @Query(value = "select c from Course c where c.createdDate >=  :createdDate")
    List<Course> deleteAllCoursesCreatedAfterDate(Date createdDate);


}
