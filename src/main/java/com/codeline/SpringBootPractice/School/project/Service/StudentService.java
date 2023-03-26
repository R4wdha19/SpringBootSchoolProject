package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.SchoolRepository;
import com.codeline.SpringBootPractice.School.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository; // reference

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolRepository schoolRepository;

    public Student getStudentById(Integer id) {
        Student student = studentRepository.getStudentById(id);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }


    public List<Student> getStudentsBySchoolName(String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        Integer schoolId = school.getId();
        List<Student> students = studentRepository.getStudentBySchoolId(schoolId);
        return students;
    }

    public Student getStudentByStudentName(String studentName) {
        Student student = studentRepository.getStudentByStudentName(studentName);
        return student;
    }

    public List<Student> getAllActiveStudents() {
        List<Student> allActiveStudents = studentRepository.getAllActiveStudents();
        return allActiveStudents;
    }

    public Student getByStudentByRollNumber(Integer studentRollNumber) {
        Student student = studentRepository.getByStudentByRollNumber(studentRollNumber);
        return student;
    }

    public List<Student> getAllInActiveStudents() {
        List<Student> allInActiveStudents = studentRepository.getAllInActiveStudents();
        return allInActiveStudents;
    }

    public List<Student> getStudentCreatedAfterDate() {
        List<Student> studentCreatedAfterDate = studentRepository.getStudentCreatedAfterDate();
        return studentCreatedAfterDate;
    }

    public Student getLatestRow() {
        Student student = studentRepository.getLatestRow();
        return student;
    }

    public Student getLatestUpdatedDate() {
        Student student = studentRepository.getLatestUpdatedDate();
        return student;
    }

    public List<Student> getStudentsBySchoolId(Integer schoolId) {
        List<Student> students = studentRepository.getStudentBySchoolId(schoolId);
        return students;
    }

    public List<Student> getStudentsByCreatedDate(String createdDate) {
        List<Student> student = studentRepository.getStudentsByCreatedDate(createdDate);
        return student;
    }

    public List<Student> getStudentsByUpdatedDate(String updatedDate) {
        List<Student> student = studentRepository.getStudentsByUpdatedDate(updatedDate);
        return student;
    }


    public void deleteStudentById(Integer studentId) {
        Student student = studentRepository.getStudentById(studentId);
        student.setIsActive(false);
        studentRepository.save(student);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }

    public void deleteStudentByName(String studentName) {
        Student student = studentRepository.getStudentByStudentName(studentName);
        student.setIsActive(false);
        studentRepository.save(student);
    }

    public void deleteByStudentByRollNumber(Integer rollNumber) {
        Student student = studentRepository.getByStudentByRollNumber(rollNumber);
        student.setIsActive(false);
        studentRepository.save(student);
    }

    public void deleteStudentsBySchoolId(Integer schoolId) {
        List<Student> student = studentRepository.getStudentBySchoolId(schoolId);
        student.stream().forEach(x -> x.setIsActive(false));
        studentRepository.saveAll(student);
    }


    public void deleteStudentsByCreatedDate(String createdDate) {
        List<Student> student = studentRepository.getStudentsByCreatedDate(createdDate);
        student.stream().forEach(x -> x.setIsActive(false));
        studentRepository.saveAll(student);
    }

    public void deleteStudentsByUpdatedDate(String updatedDate) {
        List<Student> student = studentRepository.getStudentsByUpdatedDate(updatedDate);
        student.stream().forEach(x -> x.setIsActive(false));
        studentRepository.saveAll(student);
    }

    public void createStudent(String studentName, Integer rollNumber, Integer schoolId) {
        Student student = new Student();
        student.setStudentName(studentName);
        student.setStudentRollNumber(rollNumber);
        student.setSchool(schoolService.getSchoolById(schoolId));
        student.setCreatedDate(new Date());
        student.setIsActive(Boolean.TRUE);
        studentRepository.save(student);
    }


    public void updateStudent(Integer id, String studentName, Integer rollNumber, Integer schoolId, Boolean isActive) {
        Student student = studentRepository.getStudentById(id);
        student.setStudentName(studentName);
        student.setStudentRollNumber(rollNumber);
        student.setSchool(schoolService.getSchoolById(schoolId));
        student.setIsActive(isActive);
        studentRepository.save(student);
    }

    public StringBuilder formatStudentObjectForSlack(Student student) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Id: *" + student.getId() + "*\n");
        stringBuilder.append(" Student Name Is : *" + student.getStudentName() + "*\n");
        stringBuilder.append(" Student Roll Number Is : *" + student.getStudentRollNumber() + "*\n");
        stringBuilder.append(" Student School Id Is : * " + student.getSchool().getId() + "*\n");
        stringBuilder.append(" Student Is Active: *" + student.getIsActive() + "*\n");
        stringBuilder.append(" Student Created Date Is : *"+ student.getCreatedDate()+ "*\n");
        stringBuilder.append(" Student Updated Date Is : *"+ student.getUpdatedDate()+ "*\n");
        return stringBuilder;
    }

    public StringBuilder formatStudentListForSlack(List<Student> students) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student studentFromListOfStudents : students) {
            stringBuilder.append(formatStudentObjectForSlack(studentFromListOfStudents));
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }


}
