package com.example.exammicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamQuestion {
    String questionId;
    String selectedAnswerId;
    String displayTime;
    String answerTime;
}
