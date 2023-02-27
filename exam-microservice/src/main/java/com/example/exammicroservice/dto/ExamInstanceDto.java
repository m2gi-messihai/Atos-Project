package com.example.exammicroservice.dto;

import java.util.List;

import com.example.exammicroservice.model.GeneratedLink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamInstanceDto {

    String examInstanceId;
    String examDefinitionId;
    String startedTime;
    String endTime;
    String duration;
    String completionTime;
    GeneratedLink generatedLink;
    String createdBy;
    String takenBy;
    String status;
    List<ExamQuestionDto> examQuestions;

}
