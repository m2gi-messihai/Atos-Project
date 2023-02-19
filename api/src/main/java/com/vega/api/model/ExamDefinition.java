package com.vega.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ExamDefinition")
@Data
@NoArgsConstructor
public class ExamDefinition {
    @Id
    private String id;
    private String name;
    private String passingScore;
    private String[] questionsIds;
}
