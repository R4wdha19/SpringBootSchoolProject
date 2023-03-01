package com.codeline.SpringBootPractice.School.project.Repository;

import com.codeline.SpringBootPractice.School.project.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query(value = "SELECT s from School s")
// this is a function declaration
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id = :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);


    @Query(value = "select s from School s where s.schoolName = :schoolName")
    School getSchoolByName(@Param("schoolName") String schoolName);

    @Query(value = "select s from School s where s.isActive = 1")
    List<School> getAllActiveSchools();

    @Query(value = "select s from School s where s.isActive = 0")
    List<School> getAllInActiveSchools();

    @Query(value = "select  s from School s where s.createdDate >= '2022-02-25'")
    List<School> getSchoolCreatedAfterDate();

    @Query(value = "select s from School s where s.id = (select Max(s.id) from School s )")
    School getLatestRow();

    @Query(value = " select s from School s where s.updatedDate = (select Max(s.updatedDate) from School s)")
    School getLatestUpdatedDate();

    @Modifying
    @Transactional
    @Query(value = "Update School s Set s.isActive =false")
    void deleteAllSchoolsByIsActiveFalse();


   /* @Query(value = "  Update school Set is_active = 0 where id =:schoolId", nativeQuery = true)
    School deleteSchoolById(@Param("schoolId") Integer id);*/

  /*  @Query(value = " select s from School s where s.isActive =(Update school  Set isActive = 0 )")
    List<School> deleteAll();

    School deleteByName();*/

}

