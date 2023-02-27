package com.codeline.SpringBootPractice.School.project.RequestObjects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data

public class SchoolRequestForCreateDateUpdate {
    String date;
    Integer id;
}
