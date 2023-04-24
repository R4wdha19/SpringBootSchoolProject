package com.codeline.SpringBootPractice.School.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class CourseWithStudentCountDTO {
    String courseName;
    Integer countOfStudents;
}
