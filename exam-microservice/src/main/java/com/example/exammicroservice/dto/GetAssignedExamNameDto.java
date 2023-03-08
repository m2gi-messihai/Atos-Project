package com.example.exammicroservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAssignedExamNameDto {
    String examInstanceId;
    String examDefinitionName;
    String examDuration;
    String startTime;
    List<ExamQuestionDto> questions;

}
