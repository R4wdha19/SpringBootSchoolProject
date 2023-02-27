package com.codeline.SpringBootPractice.School.project.Repository;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT st from Student st")
    List<Student> getAllStudents();



    @Query(value = "SELECT st from Student st where st.id = :studentId")
    Student getStudentById(@Param("studentId") Integer id);


    @Query(value = "select st from Student st where st.school.id = :schoolId")
    List<Student> getStudentBySchoolId(@Param("schoolId") Integer id);

    @Query(value = "select st from Student st where st.studentName = :studentName")
    Student getStudentByStudentName(@Param("studentName") String studentName);

    @Query(value = "select st from Student st where st.isActive = 1")
    List<Student> getAllActiveStudents();

    @Query(value = "select st from Student st where st.isActive = 0")
    List<Student> getAllInActiveStudents();

    @Query(value = "select st from Student st where st.createdDate >= '2022-02-25'")
    List<Student> getStudentCreatedAfterDate();
   /* @Query(value = "update student set isActive = 0 where id =1; ")
    Student deleteStudentById(@Param("studentId") Integer id);*/



}