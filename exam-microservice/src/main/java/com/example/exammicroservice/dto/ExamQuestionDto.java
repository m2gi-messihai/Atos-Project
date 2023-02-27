package com.example.exammicroservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamQuestionDto {
    String questionId;
    String selectedAnswerId;
    String displayTime;
    String answerTime;

}
