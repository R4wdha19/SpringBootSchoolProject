package com.codeline.SpringBootPractice.School.project.Slack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SlackPayLoad {

    private String text;

    public SlackPayLoad(String text) {
        this.text = text;
    }
}
