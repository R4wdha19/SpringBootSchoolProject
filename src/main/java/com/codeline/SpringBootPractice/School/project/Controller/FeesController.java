package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Fees;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.FeesService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "Fees")
public class FeesController {
    @Autowired
    FeesService feesService;

    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Fees> getAllFees() {
        List<Fees> fees = new ArrayList<>();
        fees = feesService.getAllFees();
        slackClient.sendMessage(feesService.formatFeesListForSlack(fees).toString());
        return fees;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Fees getFeeById(@RequestParam Integer feeId) {
        Fees feeById = feesService.getFeeById(feeId);
        return feeById;
    }
    @RequestMapping(value = "getByStudentId", method = RequestMethod.GET)
    public Fees getFeeByStudentId(@RequestParam Integer studentId) {
        Fees feeByStudentId = feesService.getFeeByStudentId(studentId);
        return feeByStudentId;
    }
    @RequestMapping(value = "getByAmount", method = RequestMethod.GET)
    public List<Fees> getFeesByAmount(@RequestParam Integer amount) {
        List<Fees> feesListByAmount = feesService.getFeesByAmount(amount);
        return feesListByAmount;
    }

    @RequestMapping(value = "getByPaidDate", method = RequestMethod.GET)
    public List<Fees> getFeesByPaidDate(@RequestParam String paidDate){
        List<Fees> feesListByPaidDate = feesService.getFeesByPaidDate(paidDate);
        return feesListByPaidDate;
    }
    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public List<Fees> getFeesByCreatedDate(@RequestParam String createdDate){
        List<Fees> feesListByCreatedDate= feesService.getFeesByCreatedDate(createdDate);
        return feesListByCreatedDate;
    }
    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public List<Fees> feesListByUpdatedDate(@RequestParam String updatedDate){
        List<Fees> feesListByUpdatedDate = feesService.getFeesByUpdatedDate(updatedDate);
        return feesListByUpdatedDate;
    }

    @RequestMapping(value = "getAllActiveFees", method = RequestMethod.GET)
    public List<Fees> getAllActiveFees() {
        List<Fees> activeFeesList = feesService.getAllActiveFees();
        return activeFeesList;
    }
    @RequestMapping(value = "getAllInActiveFees", method = RequestMethod.GET)
    public List<Fees> getAllInActiveFees() {
        List<Fees> allInActiveFees = feesService.getAllInActiveFees();
        return allInActiveFees;
    }

}
