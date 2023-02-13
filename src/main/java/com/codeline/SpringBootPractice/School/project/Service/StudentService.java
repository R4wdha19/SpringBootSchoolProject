package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public Student getStudentById(Integer id){
        Student student=studentRepository.getStudentById(id);
        return student;
    }
    public Student getStudentBySchoolId(Integer id){
        Student student=studentRepository.getStudentById(id);
        return student;
    }
}
