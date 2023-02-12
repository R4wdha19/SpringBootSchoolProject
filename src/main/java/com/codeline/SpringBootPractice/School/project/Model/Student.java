package com.codeline.SpringBootPractice.School.project.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String studentName;
    Integer studentRollNumber;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    School school;

}
