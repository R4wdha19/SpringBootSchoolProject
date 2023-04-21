package com.codeline.SpringBootPractice.School.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class CourseWithGradesDTO {
    String courseName;
    String grade;
    Integer countOfMarks;

}
