package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Mark;

import com.codeline.SpringBootPractice.School.project.Repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarkService {

    @Autowired
    MarkRepository markRepository;

    public List<Mark> getAllMarks(){
        return markRepository.getAllMarks();
    }
    public Mark getMarkById(Integer id){
        Mark mark=markRepository.getMarkById(id);
        return mark;
    }



}
