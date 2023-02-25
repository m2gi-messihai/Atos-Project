package com.example.exammicroservice.dto;

import java.util.List;

import com.example.exammicroservice.model.GeneratedLink;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamInstanceDto {

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
