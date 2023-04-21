package com.codeline.SpringBootPractice.School.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class TopPerformingStudentDTO {
    String studentName;
    String schoolName;



}
