package com.example.exammicroservice.webclientApi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.example.exammicroservice.dto.QuestionDto;

import reactor.core.publisher.Mono;

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

    public List<QuestionDto> getQuestionsByIds(List<String> ids) {
        Mono<List<QuestionDto>> questions = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/questions/examQuestions").queryParam("ids", ids).build())
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<QuestionDto>>() {
                });
        List<QuestionDto> questionDto = questions.block();

        return questionDto.stream()
                .collect(Collectors.toList());

    }

}
