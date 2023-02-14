package com.codeline.SpringBootPractice.School.project.Model;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@MappedSuperclass
public class BaseEntity {
    @CreatedDate
    Date createdDate;
    @UpdateTimestamp
    Date updatedDate;
    Boolean isActive;
}
