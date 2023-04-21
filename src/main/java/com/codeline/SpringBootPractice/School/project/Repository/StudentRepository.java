package com.codeline.SpringBootPractice.School.project.Repository;

import com.codeline.SpringBootPractice.School.project.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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


    @Query(value = "select st from Student st where st.id = (select Max(st.id) from Student st )")
    Student getLatestRow();

    @Query(value = " select st from Student st where st.updatedDate = (select Max(st.updatedDate) from Student st)")
    Student getLatestUpdatedDate();


    @Query(value = "select distinct school_id from student", nativeQuery = true)
    List<Integer> getDistinctSchoolIdsFromStudent();

    @Query(value = "select count(id) from student where school_id = ?1", nativeQuery = true)
    Integer getCountOfStudentsBySchoolId(Integer schoolId);

    @Query(value = "select st from Student st where st.studentRollNumber = :studentRollNumber")
    Student getByStudentByRollNumber(Integer studentRollNumber);

    @Query(value = "select * from student where created_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Student> getStudentsByCreatedDate(String createdDate);

    @Query(value = "select * from student where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Student> getStudentsByUpdatedDate(String updatedDate);
    @Modifying
    @Transactional
    @Query(value = "update Student st Set st.isActive = false")
    void deleteAllStudents();

//    @Query(value = "SELECT s.studentId, s.name, c.courseId, c.courseName, MAX(m.obtainedMarks) AS highestMarks "
//            + "FROM Student s "
//            + "JOIN s.courses cs "
//            + "JOIN cs.course c "
//            + "JOIN c.marks m "
//            + "WHERE s.school.schoolId = :schoolId "
//            + "GROUP BY s.studentId, c.courseId")
//    Student getStudentWithMaxMarksBySchoolId(Integer schoolId);
}