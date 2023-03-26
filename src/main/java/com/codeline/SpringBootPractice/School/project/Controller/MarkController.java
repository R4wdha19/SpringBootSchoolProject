package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Service.MarkService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "Mark")
public class MarkController {
    @Autowired
    MarkService markService;
    @Autowired
    SlackClient slackClient;


    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks() {
        List<Mark> marks = new ArrayList<>();
        marks = markService.getAllMarks();
        slackClient.sendMessage(markService.formatMarkListForSlack(marks).toString());
        return marks;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer markId) {
        Mark markById = markService.getMarkById(markId);
        slackClient.sendMessage(markService.formatMarkObjectForSlack(markById).toString());

        return markById;

    }

    @RequestMapping(value = "getByGrade", method = RequestMethod.GET)
    public List<Mark> getMarkByGrade(@RequestParam String grade) {
        List<Mark> markByGrade = markService.getMarkByGrade(grade);
        slackClient.sendMessage(markService.formatMarkListForSlack(markByGrade).toString());
        return markByGrade;

    }

    @RequestMapping(value = "getAllActiveMarks", method = RequestMethod.GET)
    public List<Mark> getAllActiveMarks() {
        List<Mark> allActiveMarkList = new ArrayList<>();
        allActiveMarkList = markService.getAllActiveMarks();
        slackClient.sendMessage(markService.formatMarkListForSlack(allActiveMarkList).toString());
        return allActiveMarkList;
    }


    @RequestMapping(value = "getAllInActiveMarks", method = RequestMethod.GET)
    public List<Mark> getAllInActiveMarks() {
        List<Mark> allInActiveMarkList = new ArrayList<>();
        allInActiveMarkList = markService.getAllInActiveMarks();
        slackClient.sendMessage(markService.formatMarkListForSlack(allInActiveMarkList).toString());
        return allInActiveMarkList;
    }

    @RequestMapping(value = "getMarkCreatedAfterDate", method = RequestMethod.GET)
    public List<Mark> getMarkCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Mark> markList = new ArrayList<>();
        markList = markService.getMarkCreatedAfterDate(createdDate);
        slackClient.sendMessage(markService.formatMarkListForSlack(markList).toString());
        return markList;
    }


    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Mark getLatestRow() {
        Mark markLatestRow = markService.getLatestRow();
        slackClient.sendMessage(markService.formatMarkObjectForSlack(markLatestRow).toString());
        return markLatestRow;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public Mark getLatestUpdatedDate() {
        Mark markLatestUpdatedDate = markService.getLatestUpdatedDate();
        slackClient.sendMessage(markService.formatMarkObjectForSlack(markLatestUpdatedDate).toString());
        return markLatestUpdatedDate;
    }

    @RequestMapping(value = "getByObtainedMarksMoreThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksMoreThan(@RequestParam Integer obtainedMarks){
        List<Mark> obtainedMarksMoreThan=markService.getByObtainedMarksMoreThan(obtainedMarks);
        slackClient.sendMessage(markService.formatMarkListForSlack(obtainedMarksMoreThan).toString());
        return obtainedMarksMoreThan;
    }

    @RequestMapping(value = "getByObtainedMarksLessThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksLessThan(@RequestParam Integer obtainedMarks){
        List<Mark> obtainedMarksLessThan=markService.getByObtainedMarksLessThan(obtainedMarks);
        slackClient.sendMessage(markService.formatMarkListForSlack(obtainedMarksLessThan).toString());
        return obtainedMarksLessThan;
    }
    @RequestMapping(value = "getMarksByUpdatedDate", method = RequestMethod.GET)
    public List<Mark> getMarksByUpdatedDate(@RequestParam String updatedDate)  {
        List<Mark> marksByUpdatedDate=markService.getMarksByUpdatedDate(updatedDate);
        slackClient.sendMessage(markService.formatMarkListForSlack(marksByUpdatedDate).toString());
        return marksByUpdatedDate;
    }
    @RequestMapping(value = "getMarksByCourseId", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseId(@RequestParam Integer courseId){
        List<Mark> marksByCourseId=markService.getMarksByCourseId(courseId);
        slackClient.sendMessage(markService.formatMarkListForSlack(marksByCourseId).toString());
        return marksByCourseId;
    }
    @RequestMapping(value = "deleteMarkById", method = RequestMethod.POST)
    public void deleteMarkById(@RequestParam Integer markId) {
        markService.deleteMarkById(markId);
    }


    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAllMarks() {
        markService.deleteAllMarks();
    }

    @RequestMapping(value = "deleteMarkByGrade", method = RequestMethod.POST)
    public void deleteMarkByGrade(@RequestParam String markGrade) {
        markService.deleteMarkByGrade(markGrade);
    }

    @RequestMapping(value = "deleteAllMarksCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllMarksCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        markService.deleteAllMarksCreatedAfterDate(createdDate);
    }
    @RequestMapping(value = "deleteMarksByCourseId", method = RequestMethod.POST)
    public void deleteMarksByCourseId(@RequestParam Integer courseId){
        markService.deleteMarksByCourseId(courseId);
    }
    @RequestMapping(value = "deleteMarksByCreatedDate", method = RequestMethod.POST)
    public void deleteMarksByCreatedDate(@RequestParam String createdDate) {
        markService.deleteMarksByCreatedDate(createdDate);
    }
    @RequestMapping(value = "deleteMarksByUpdatedDate", method = RequestMethod.POST)
    public void deleteMarksByUpdatedDate(@RequestParam String updatedDate){
        markService.deleteMarksByUpdatedDate(updatedDate);
    }
    @RequestMapping(value = "createMark", method = RequestMethod.POST)
    public void createMark(@RequestParam String grade, Integer obtainedMark, Integer courseId) {
        markService.createMark(grade, obtainedMark, courseId);
    }

    @RequestMapping(value = "updateMark", method = RequestMethod.POST)
    public void updateMark(@RequestParam Integer markId,String grade, Integer obtainedMark, Integer courseId,Boolean isActive) {
        markService.updateMark(markId, grade, obtainedMark,courseId,isActive);
    }
}

