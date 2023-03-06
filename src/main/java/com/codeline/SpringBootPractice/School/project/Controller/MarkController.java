package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Service.MarkService;
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

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks() {
        List<Mark> marks = new ArrayList<>();
        marks = markService.getAllMarks();
        return marks;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer markId) {
        Mark mark = markService.getMarkById(markId);
        return mark;

    }

    @RequestMapping(value = "getByGrade", method = RequestMethod.GET)
    public List<Mark> getMarkByGrade(@RequestParam String grade) {
        List<Mark> mark = markService.getMarkByGrade(grade);
        return mark;

    }

    @RequestMapping(value = "getAllActiveMarks", method = RequestMethod.GET)
    public List<Mark> getAllActiveMarks() {
        List<Mark> markList = new ArrayList<>();
        markList = markService.getAllActiveMarks();
        return markList;
    }


    @RequestMapping(value = "getAllInActiveMarks", method = RequestMethod.GET)
    public List<Mark> getAllInActiveMarks() {
        List<Mark> markList = new ArrayList<>();
        markList = markService.getAllInActiveMarks();
        return markList;
    }

    @RequestMapping(value = "getMarkCreatedAfterDate", method = RequestMethod.GET)
    public List<Mark> getMarkCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Mark> markList = new ArrayList<>();
        markList = markService.getMarkCreatedAfterDate(createdDate);
        return markList;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Mark getLatestRow() {
        Mark mark = markService.getLatestRow();
        return mark;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public Mark getLatestUpdatedDate() {
        Mark mark = markService.getLatestUpdatedDate();
        return mark;
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


    @RequestMapping(value = "getByObtainedMarksMoreThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksMoreThan(@RequestParam Integer obtainedMarks){
        List<Mark> markList=markService.getByObtainedMarksMoreThan(obtainedMarks);
        return markList;
    }

    @RequestMapping(value = "getByObtainedMarksLessThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksLessThan(@RequestParam Integer obtainedMarks){
        List<Mark> markList=markService.getByObtainedMarksLessThan(obtainedMarks);
        return markList;
    }
    @RequestMapping(value = "getMarksByUpdatedDate", method = RequestMethod.GET)
    public List<Mark> getMarksByUpdatedDate(@RequestParam String updatedDate)  {
        List<Mark> markList=markService.getMarksByUpdatedDate(updatedDate);
        return markList;
    }
    @RequestMapping(value = "getMarksByCourseId", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseId(@RequestParam Integer courseId){
        List<Mark> markList=markService.getMarksByCourseId(courseId);
        return markList;
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

