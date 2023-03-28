package com.codeline.SpringBootPractice.School.project.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class School extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "SchoolName")
    String schoolName;

    public School() {
    }

    public School(Integer id) {
        this.id = id;
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public School(Integer id, String schoolName){
        this.schoolName = schoolName;
        this.id = id;
    }


}
