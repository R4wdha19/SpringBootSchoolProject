package com.codeline.SpringBootPractice.School.project.Controller;

import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Service.StudentService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
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
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students = studentService.getAllStudents();
        return students;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;

    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    public Student getStudentByStudentName(@RequestParam String studentName) {
        Student student = studentService.getStudentByStudentName(studentName);
        return student;
    }

    @RequestMapping(value = "getAllActiveStudents", method = RequestMethod.GET)
    public List<Student> getAllActiveStudents() {
        List<Student> AllActiveStudents = new ArrayList<>();
        AllActiveStudents = studentService.getAllActiveStudents();
        return AllActiveStudents;
    }

    @RequestMapping(value = "getAllInActiveStudents", method = RequestMethod.GET)
    public List<Student> getAllInActiveStudents() {
        List<Student> AllInActiveStudents = new ArrayList<>();
        AllInActiveStudents = studentService.getAllInActiveStudents();
        return AllInActiveStudents;
    }

    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate() {
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

    @RequestMapping(value = "getByStudentByRollNumber", method = RequestMethod.GET)
    public Student getByStudentByRollNumber(@RequestParam Integer studentRollNumber) {
        Student student = studentService.getByStudentByRollNumber(studentRollNumber);
        return student;
    }

    @RequestMapping(value = "getStudentsByCreatedDate", method = RequestMethod.GET)
    public List<Student> getStudentsByCreatedDate(@RequestParam String createdDate) {
        List<Student> student = studentService.getStudentsByCreatedDate(createdDate);
        return student;

    }

    @RequestMapping(value = "getStudentsByUpdatedDate", method = RequestMethod.GET)
    public List<Student> getStudentsByUpdatedDate(@RequestParam String updatedDate) {
        List<Student> student = studentService.getStudentsByUpdatedDate(updatedDate);
        return student;

    }

    @RequestMapping(value = "deleteStudentById", method = RequestMethod.POST)
    public void deleteStudentById(@RequestParam Integer studentId) {
        studentService.deleteStudentById(studentId);
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }

    @RequestMapping(value = "deleteStudentByName", method = RequestMethod.POST)
    public void deleteStudentByName(@RequestParam String studentName) {
        studentService.deleteStudentByName(studentName);
    }

    @RequestMapping(value = "createStudent", method = RequestMethod.POST)
    public void createStudent(@RequestParam String studentName, Integer rollNumber, Integer schoolId) {
        studentService.createStudent(studentName, rollNumber, schoolId);
    }
    @RequestMapping(value = "deleteByStudentByRollNumber",method = RequestMethod.POST)
    public void deleteByStudentByRollNumber(@RequestParam Integer rollNumber){
        studentService.deleteByStudentByRollNumber(rollNumber);
    }
    @RequestMapping(value = "deleteStudentsBySchoolId",method = RequestMethod.POST)
    public void deleteStudentsBySchoolId(@RequestParam Integer schoolId){
        studentService.deleteStudentsBySchoolId(schoolId);
    }
    @RequestMapping(value = "deleteStudentsByCreatedDate",method = RequestMethod.POST)
    public void deleteStudentsByCreatedDate(@RequestParam String createdDate){
        studentService.deleteStudentsByCreatedDate(createdDate);
    }
    @RequestMapping(value = "deleteStudentsByUpdatedDate",method = RequestMethod.POST)
    public void deleteStudentsByUpdatedDate(@RequestParam String updatedDate){
        studentService.deleteStudentsByUpdatedDate(updatedDate);
    }
    @RequestMapping(value = "updateCourse",method = RequestMethod.POST)
    public void updateStudent(@RequestParam Integer id,String studentName, Integer rollNumber, Integer schoolId, Boolean isActive){
        studentService.updateStudent(id,studentName,rollNumber,schoolId,isActive);
    }

}
