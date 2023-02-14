package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
StudentService studentService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students = studentService.getAllStudents();
        return students;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;

    }
@RequestMapping(value = "/getByName")
    public Student getStudentByStudentName(@RequestParam String studentName){
        Student student = studentService.getStudentByStudentName(studentName);
        return student;
    }

    @RequestMapping(value = "getAllActiveStudents", method = RequestMethod.GET)
    public List<Student> getAllActiveStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList = studentService.getAllActiveStudents();
        return studentList;
    }
}
