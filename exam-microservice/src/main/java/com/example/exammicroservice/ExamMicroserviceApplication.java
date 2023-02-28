package com.example.exammicroservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.exammicroservice.webclientApi.WebClientApi;

@SpringBootApplication
public class ExamMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamMicroserviceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	@Bean
	public WebClientApi webClientApi() {
		return new WebClientApi();
	}

}
