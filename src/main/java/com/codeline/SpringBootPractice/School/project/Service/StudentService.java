package com.codeline.SpringBootPractice.School.project.Service;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Model.Student;
import com.codeline.SpringBootPractice.School.project.Repository.SchoolRepository;
import com.codeline.SpringBootPractice.School.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository; // reference

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolRepository schoolRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Integer id) {
        Student student = studentRepository.getStudentById(id);
        return student;
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

    public void createStudent(String studentName, Integer rollNumber, Integer schoolId) {
        Student student = new Student();
        student.setStudentName(studentName);
        student.setStudentRollNumber(rollNumber);
        student.setSchool(schoolService.getSchoolById(schoolId));
        student.setCreatedDate(new Date());
        student.setIsActive(Boolean.TRUE);
        studentRepository.save(student);
    }

    public List<Student> getStudentsBySchoolId(Integer schoolId) {
        List<Student> students = studentRepository.getStudentBySchoolId(schoolId);
        return students;
    }

/*    public void getSchoolByNumberOfStudents(Integer numberOfStudents) {
        List<Student> students = studentRepository.getAllStudents();
        List<School> schools = new ArrayList<>();
        Set<Integer> schoolIds = new HashSet<>();
        List<Integer> schoolIdList = new ArrayList<>();
        for (Student s: students) {
            schools.add(s.getSchool());
            schoolIds.add(s.getSchool().getId());
            schoolIdList.add(s.getSchool().getId());
        }



    }*/

}
