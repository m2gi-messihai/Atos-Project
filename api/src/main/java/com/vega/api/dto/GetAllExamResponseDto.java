package com.vega.api.dto;

import lombok.Data;

@Data
public class GetAllExamResponseDto {
    ExamDefinitionDto[] examDefinitionDtos;
    Integer pageSize;
    Long totalQuestions;
    Integer offset;
    Integer totalPages;
    private Integer pageNumber;
    private Boolean last;

}
