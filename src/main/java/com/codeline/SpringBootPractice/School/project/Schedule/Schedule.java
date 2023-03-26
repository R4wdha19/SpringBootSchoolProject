package com.codeline.SpringBootPractice.School.project.Schedule;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class Schedule {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;


    @Scheduled(cron="0 0/15 * * * *")
    public void getAllSchools() {
      List<School> schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

}
