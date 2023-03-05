package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Mark> getMarkCreatedAfterDate(@RequestParam String createdDate) {
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

    @RequestMapping(value = "createMark", method = RequestMethod.POST)
    public void createMark(@RequestParam String grade, Integer obtainedMark, Integer courseId) {
        markService.createMark(grade, obtainedMark, courseId);
    }
}

