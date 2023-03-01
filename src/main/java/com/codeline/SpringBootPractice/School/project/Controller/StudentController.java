package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//YOU DONT EVEN HAVE 1 Create API
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
        List<Student> AllActiveStudents = new ArrayList<>();
        AllActiveStudents = studentService.getAllActiveStudents();
        return AllActiveStudents;
    }

    @RequestMapping(value = "getAllInActiveStudents", method = RequestMethod.GET)
    public List<Student> getAllInActiveStudents(){
        List<Student> AllInActiveStudents = new ArrayList<>();
        AllInActiveStudents = studentService.getAllInActiveStudents();
        return AllInActiveStudents;
    }
    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(){
        List<Student> studentList = new ArrayList<>();
        studentList = studentService.getStudentCreatedAfterDate();
        return studentList;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Student getLatestRow() {
        Student student = studentService.getLatestRow();
        return student;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public Student getLatestUpdatedDate() {
        Student student = studentService.getLatestUpdatedDate();
        return student;
    }

}
