package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MarkService {

    @Autowired
    MarkRepository markRepository;
    @Autowired
    CourseService courseService;

    public Mark getMarkById(Integer id) {
        Mark mark = markRepository.getMarkById(id);
        return mark;
    }

    public List<Mark> getAllMarks() {
        return markRepository.getAllMarks();
    }

    public List<Mark> getAllActiveMarks() {
        List<Mark> allActiveMarks = markRepository.getAllActiveMarks();
        return allActiveMarks;
    }

    public List<Mark> getMarkByGrade(String grade) {
        List<Mark> mark = markRepository.getMarkByGrade(grade);
        return mark;
    }

    public List<Mark> getAllInActiveMarks() {
        List<Mark> allInActiveMarks = markRepository.getAllInActiveMarks();
        return allInActiveMarks;
    }


    public List<Mark> getMarkCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = dateFormat.parse(createdDate);
        List<Mark> markCreatedAfterDate = markRepository.getMarkCreatedAfterDate(formatedDate);
        return markCreatedAfterDate;
    }

    public Mark getLatestRow() {
        Mark mark = markRepository.getLatestRow();
        return mark;
    }

    public Mark getLatestUpdatedDate() {
        Mark mark = markRepository.getLatestUpdatedDate();
        return mark;
    }

    public List<Mark> getByObtainedMarksMoreThan(Integer obtainedMarks) {
        List<Mark> obtainedMarksList = markRepository.getByObtainedMarksMoreThan(obtainedMarks);
        return obtainedMarksList;
    }

    public List<Mark> getByObtainedMarksLessThan(Integer obtainedMarks) {
        List<Mark> obtainedMarksList = markRepository.getByObtainedMarksLessThan(obtainedMarks);
        return obtainedMarksList;
    }

    public List<Mark> getMarksByUpdatedDate(String updatedDate) {
        List<Mark> marksByUpdatedDate = markRepository.getMarksByUpdatedDate(updatedDate);
        return marksByUpdatedDate;
    }

    public List<Mark> getMarksByCourseId(Integer courseId) {
        List<Mark> marksByCourseId = markRepository.getMarksByCourseId(courseId);
        return marksByCourseId;
    }

    public void deleteMarkById(Integer markId) {
        Mark mark = markRepository.getMarkById(markId);
        mark.setIsActive(false);
        markRepository.save(mark);
    }

    public void deleteAllMarks() {
        markRepository.deleteAllMarks();
    }


    public void deleteMarkByGrade(String grade) {
        List<Mark> mark = markRepository.getMarkByGrade(grade);
        mark.stream().forEach(m -> m.setIsActive(false));
        markRepository.saveAll(mark);
    }

    public void deleteAllMarksCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = dateFormat.parse(createdDate);
        List<Mark> markList = markRepository.getMarkCreatedAfterDate(formatedDate);
        markList.stream().forEach(r -> r.setIsActive(false));
        markRepository.saveAll(markList);
    }
    public void deleteMarksByCourseId(Integer courseId){
        List<Mark> mark = markRepository.getMarksByCourseId(courseId);
        mark.stream().forEach(m -> m.setIsActive(false));
        markRepository.saveAll(mark);
    }
    public void deleteMarksByCreatedDate(String createdDate) {
        List<Mark> mark = markRepository.getMarkByCreatedDate(createdDate);
        mark.stream().forEach(m -> m.setIsActive(false));
        markRepository.saveAll(mark);
    }
    public void deleteMarksByUpdatedDate(String updatedDate){
        List<Mark> mark = markRepository.getMarksByUpdatedDate(updatedDate);
        mark.stream().forEach(m -> m.setIsActive(false));
        markRepository.saveAll(mark);
    }
    public void createMark(String grade, Integer obtainedMark, Integer courseId) {
        Mark mark = new Mark();
        mark.setGrade(grade);
        mark.setCourse(courseService.getCourseById(courseId));
        mark.setObtainedMarks(obtainedMark);
        mark.setCreatedDate(new Date());
        mark.setIsActive(true);
        markRepository.save(mark);
    }
    public void updateMark(Integer markId,String grade, Integer obtainedMark, Integer courseId,Boolean isActive) {
        Mark mark= markRepository.getMarkById(markId);
        mark.setGrade(grade);
      mark.setObtainedMarks(obtainedMark);
      mark.setCourse(courseService.getCourseById(courseId));
        mark.setIsActive(isActive);
        markRepository.save(mark);
    }



}
