package com.vega.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vega.api.dto.ExamDefinitionDto;
import com.vega.api.model.ExamDefinition;
import com.vega.api.services.ExamDefinitionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
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
