package com.example.exammicroservice.webclientApi;

import org.springframework.web.reactive.function.client.WebClient;

import com.example.exammicroservice.dto.QuestionDto;

public class WebClientApi {

    WebClient webClient = WebClient.create("http://localhost:8080");

    public QuestionDto getQuestionById(String id) {
        QuestionDto question = webClient.get()
                .uri("/questions/" + id)
                .retrieve()
                .bodyToMono(QuestionDto.class)
                .block();
        return question;

    }

}
