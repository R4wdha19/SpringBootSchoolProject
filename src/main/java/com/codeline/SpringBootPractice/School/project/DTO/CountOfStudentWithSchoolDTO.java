package com.codeline.SpringBootPractice.School.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@AllArgsConstructor
@Setter
public class CountOfStudentWithSchoolDTO {
    String schoolName;
    Integer countOfStudents;
}
