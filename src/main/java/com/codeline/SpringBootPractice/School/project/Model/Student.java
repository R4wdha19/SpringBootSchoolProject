package com.codeline.SpringBootPractice.School.project.Model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Setter
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "StudentName")
    String studentName;
    Integer studentRollNumber;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    School school;

}
