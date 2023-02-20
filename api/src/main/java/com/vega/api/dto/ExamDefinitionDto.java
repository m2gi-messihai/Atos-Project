package com.vega.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamDefinitionDto {
    private String examId;
    private String name;
    private String passingScore;
    private String[] questionsIds;

}
