package com.vega.api.dto;

import java.util.List;

import com.vega.api.model.Question;

import lombok.Data;

@Data
public class GetAllQuestionsResponseDto {
    List<Question> questions;

    Integer pageSize;
    Long totalQuestions;
    Integer offset;
    Integer totalPages;
    private Integer pageNumber;
    private Boolean last;

}
