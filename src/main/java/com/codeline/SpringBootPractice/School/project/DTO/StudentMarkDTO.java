package com.codeline.SpringBootPractice.School.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class StudentMarkDTO {
    Integer studentId;
    Integer studentRollNumber;
    String studentName;
    Integer averageMark;
}
