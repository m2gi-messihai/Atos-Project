package com.vega.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vega.api.dto.ExamDefinitionDto;
import com.vega.api.model.ExamDefinition;
import com.vega.api.services.ExamDefinitionService;

public class ExamDefinitionController {
    @Autowired
    private ExamDefinitionService examDefinitionService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/examForm")
    public ExamDefinitionDto createExamDefinition(@RequestBody ExamDefinitionDto examDefinitionDto) {
        ExamDefinition examDefinition = modelMapper.map(examDefinitionDto, ExamDefinition.class);
        examDefinitionService.createExamDefinition(examDefinition);
        return modelMapper.map(examDefinition, ExamDefinitionDto.class);

    }

}
