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

}