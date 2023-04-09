package com.codeline.SpringBootPractice.School.project.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CourseMarkObject {
    String courseName;
    Integer obtainedMarks;
    String grade;

    Integer averageMark;
}
