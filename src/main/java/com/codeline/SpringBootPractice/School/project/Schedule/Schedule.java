package com.codeline.SpringBootPractice.School.project.Schedule;

import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Service.SchoolService;
import com.codeline.SpringBootPractice.School.project.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component

public class Schedule {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;


    @Scheduled(cron = "0 0/15 * * * *")
    public void getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "0 0/16 * * * *")
    public void getSchoolById() {
        School school = schoolService.getSchoolById(1);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }

    @Scheduled(cron = "0 0/17 * * * *")
    public void getSchoolByName() {
        School school = schoolService.getSchoolByName("AlTqwa");
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }

    @Scheduled(cron = "0 0/18 * * * *")
    public void getAllActiveSchools() {
        List<School> schools = schoolService.getAllActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "0 0/19 * * * *")
    public void getAllInActiveSchools() {
        List<School> schools = schoolService.getAllInActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void getSchoolCreatedAfterDate() throws ParseException {
        List<School> schools = schoolService.getSchoolCreatedAfterDate("2022-02-25");
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
    }

    @Scheduled(cron = "0 0/21 * * * *")
    public void getLatestRow() {
        School school = schoolService.getLatestRow();
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }

    @Scheduled(cron = "0 0/22 * * * *")
    public void getLatestUpdatedDate() {
        School school = schoolService.getLatestUpdatedDate();
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
    }


}
