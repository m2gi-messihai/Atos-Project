package com.vega.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamDefinitionDto {
    private String id;
    private String name;
    private String passingScore;
    private String[] questionsIds;

}
