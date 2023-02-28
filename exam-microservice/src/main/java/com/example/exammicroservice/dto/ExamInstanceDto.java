package com.example.exammicroservice.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.exammicroservice.model.GeneratedLink;
import com.example.exammicroservice.model.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamInstanceDto {

    String examInstanceId;
    String examDefinitionId;
    LocalDate startedTime;
    String endTime;
    String duration;
    String completionTime;
    GeneratedLink generatedLink;
    String createdBy;
    String takenBy;
    StatusEnum status;
    List<ExamQuestionDto> examQuestions;

}
