package com.codeline.SpringBootPractice.School.project.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Setter
@Getter
@Entity
public class Fees extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer amount;
    Date datePaid;
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;
}
