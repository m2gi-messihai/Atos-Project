package com.example.exammicroservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "ExamInstance")
@Data
@AllArgsConstructor
public class ExamInstance {
    @Id
    String examInstanceId;
    String examDefinitionID;
    String startedTime;
    String endTime;
    String duration;
    String completionTime;
    GeneratedLink generatedLink;
    String createdBy;
    String takenBy;
    String status;
    List<ExamQuestion> examQuestions;

}
