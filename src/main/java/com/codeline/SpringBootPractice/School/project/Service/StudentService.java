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
    StudentRepository studentRepository; // reference

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
        List<Student> allActiveStudents = studentRepository.getAllActiveStudents();
        return allActiveStudents;
    }

    public List<Student> getAllInActiveStudents(){
        List<Student> allInActiveStudents = studentRepository.getAllInActiveStudents();
        return allInActiveStudents;
    }


}
