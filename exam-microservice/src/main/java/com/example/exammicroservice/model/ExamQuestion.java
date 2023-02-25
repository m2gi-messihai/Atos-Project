package com.example.exammicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamQuestion {
    String questionId;
    String selectedAnswerId;
    String displayTime;
    String answerTime;

}
