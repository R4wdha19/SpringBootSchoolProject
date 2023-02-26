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

    public List<Mark> getMarkByGrade(String grade){
       List<Mark>  mark = markRepository.getMarkByGrade(grade);
        return mark;
    }
    public List<Mark> getAllActiveMarks(){
        List<Mark> allActiveMarks = markRepository.getAllActiveMarks();
        return allActiveMarks;
    }
    public List<Mark> getAllInActiveMarks(){
        List<Mark> allInActiveMarks = markRepository.getAllInActiveMarks();
        return allInActiveMarks;
    }

    public List<Mark> getMarkCreatedAfterDate(){
        List<Mark> markCreatedAfterDate = markRepository.getMarkCreatedAfterDate();
        return markCreatedAfterDate;
    }



 /*   public List<Mark> getMarksByCourseName(String courseName){

    }
*/


}
