package com.example.exammicroservice.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ExamDefinition")
@Data
@NoArgsConstructor
public class ExamDefinition {
    @Id
    private String examId;
    private String name;
    private String passingScore;
    private String[] questionsIds;
}
