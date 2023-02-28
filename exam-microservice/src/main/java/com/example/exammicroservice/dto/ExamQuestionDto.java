package com.example.exammicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamQuestionDto {
    String questionId;
    String selectedAnswerId;
    String displayTime;
    String answerTime;

}
