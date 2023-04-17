package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Course;
import com.codeline.SpringBootPractice.School.project.Model.Fees;
import com.codeline.SpringBootPractice.School.project.Repository.FeesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeesService {
    @Autowired
    FeesRepository feesRepository;
    public List<Fees> getAllFees() {
        return feesRepository.getAllFees();
    }

    public Fees getFeeById(Integer id){
        Fees feeById = feesRepository.getFeeById(id);
        return feeById;
    }
    public Fees getFeeByStudentId(Integer studentId){
        Fees feeByStudentId = feesRepository.getFeeByStudentId(studentId);
        return feeByStudentId;
    }
    public List<Fees> getFeesByAmount(Integer amount){
        List<Fees> feesListByAmount = feesRepository.getFeeByAmount(amount);
        return feesListByAmount;
    }
    public List<Fees> getFeesByPaidDate(String paidDate){
        List<Fees> feesListByPaidDate = feesRepository.getFeesByPaidDate(paidDate);
        return feesListByPaidDate;
    }
    public List<Fees> getFeesByCreatedDate(String createdDate){
        List<Fees> feesListByCreatedDate = feesRepository.getFeesByCreatedDate(createdDate);
        return feesListByCreatedDate;
    }   public List<Fees> getFeesByUpdatedDate(String updatedDate){
        List<Fees> feesListByUpdatedDate = feesRepository.getFeesByUpdatedDate(updatedDate);
        return feesListByUpdatedDate;
    }
    public List<Fees> getAllActiveFees() {
        List<Fees> allActiveFees = feesRepository.getAllActiveFees();
        return allActiveFees;
    }
    public List<Fees> getAllInActiveFees() {
        List<Fees> allInActiveFees = feesRepository.getAllInActiveFees();
        return allInActiveFees;
    }


    public StringBuilder formatFeeObjectForSlack(Fees fee){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Id: *" + fee.getId() + "*\n");
        stringBuilder.append("Name Of Student Is : "+ fee.getStudent().getStudentName());
        stringBuilder.append(" Amount Is: *" + fee.getAmount() + "*\n");
        stringBuilder.append(" Paid Date Is : "+fee.getDatePaid()+ "*\n");
        stringBuilder.append(" Is Active: *" + fee.getIsActive() + "*\n");
        stringBuilder.append(" Created Date Is : *"+ fee.getCreatedDate()+ "*\n");
        stringBuilder.append(" Updated Date Is : *"+ fee.getUpdatedDate()+ "*\n");
        return stringBuilder;
    }
    public StringBuilder formatFeesListForSlack(List<Fees> fees){
        StringBuilder stringBuilder = new StringBuilder();
        for (Fees feeFromListOfFees: fees) {
            stringBuilder.append(formatFeeObjectForSlack(feeFromListOfFees));
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }
}
