package com.codeline.SpringBootPractice.School.project.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Data
@Setter
@Getter
@Entity
public class Mark  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer obtainedMarks;

    String grade;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;
}
