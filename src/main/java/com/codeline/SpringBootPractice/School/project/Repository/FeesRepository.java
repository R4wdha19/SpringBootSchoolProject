package com.codeline.SpringBootPractice.School.project.Repository;
import com.codeline.SpringBootPractice.School.project.Model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Integer> {
    @Query(value = "SELECT f from Fees f")
    List<Fees> getAllFees();

    @Query(value = "SELECT f from Fees f where f.id = :feeId")
    Fees getFeeById(@Param("feeId") Integer id);
    @Query(value = "SELECT f from Fees f where f.amount = :feeAmount")
    List<Fees> getFeeByAmount(@Param("feeAmount")Integer amount);

    @Query (value ="select * from fees where date_paid like CONCAT (?1, '%') ", nativeQuery = true )
    List<Fees> getFeesByPaidDate(@Param("paidDate") String paidDate);
    @Query(value = "Select f from Fees f where f.student.id = :studentId")
    Fees getFeeByStudentId(@Param("studentId")Integer studentId);
    @Query (value ="select * from fees where created_date like CONCAT (?1, '%') ", nativeQuery = true )
    List<Fees> getFeesByCreatedDate(@Param("createdDate") String createdDate);
    @Query (value ="select * from fees where updated_date like CONCAT (?1, '%') ", nativeQuery = true )
    List<Fees> getFeesByUpdatedDate(@Param("updatedDate") String updatedDate);
    @Query(value = "select f from Fees f where f.isActive = 1")
    List<Fees> getAllActiveFees();
    @Query(value = "select f from Fees f where f.isActive = 0")
    List<Fees> getAllInActiveFees();
}
