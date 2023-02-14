package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.Mark;
import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.SchoolRepository;
import com.codeline.SpringBootPractice.School.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolService schoolService;

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public Student getStudentById(Integer id){
        Student student=studentRepository.getStudentById(id);
        return student;
    }




    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolService.getSchoolByName(schoolName);
        Integer schoolId = school.getId();
        List<Student> students=studentRepository.getStudentBySchoolId(schoolId);
        return students;
    }

    public Student getStudentByStudentName(String studentName){
       Student student = studentRepository.getStudentByStudentName(studentName);
        return student;
    }
    public List<Student> getAllActiveStudents(){
        List<Student> studentList = studentRepository.getAllActiveStudents();
        return studentList;
    }


}
