package com.codeline.SpringBootPractice.School.project.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity {
    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Muscat")
    Date createdDate;
    @UpdateTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Muscat")
    Date updatedDate;
    Boolean isActive;


}
