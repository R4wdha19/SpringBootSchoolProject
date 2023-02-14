package com.codeline.SpringBootPractice.School.project.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Data
@Setter
@Getter
@Entity
public class Student  extends BaseEntity {
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
