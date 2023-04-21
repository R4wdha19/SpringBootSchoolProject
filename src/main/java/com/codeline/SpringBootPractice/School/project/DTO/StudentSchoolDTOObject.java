package com.codeline.SpringBootPractice.School.project.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentSchoolDTOObject {
    String studentName;
    String schoolName;
    Integer studentRollNumber;
}
