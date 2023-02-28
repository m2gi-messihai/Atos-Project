package com.example.exammicroservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDto {

    private String id;
    private String name;
    private String levelId;
    private String typeId;
    private String key;
    private String category;
    private String subCategory;
    private String mark;
    private String expectedTime;
    private String correctAnswerIds[];
    private String createdBy;
    private String createdAt;
    private AnswerDto[] answers;

}
