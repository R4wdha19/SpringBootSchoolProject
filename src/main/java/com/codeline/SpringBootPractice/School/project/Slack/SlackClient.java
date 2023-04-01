package com.codeline.SpringBootPractice.School.project.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
@Component
public class SlackClient {

    public String sendMessage(String text) {
        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayLoad(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
