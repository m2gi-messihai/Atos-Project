package com.vega.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PatchMapping("/{id}")
    public ExamDefinitionDto addNewAnswer(@PathVariable String id, @RequestBody String[] questionsIds) {
        ExamDefinition examDefinition = examDefinitionService.addNewQuestion(id, questionsIds);
        return modelMapper.map(examDefinition, ExamDefinitionDto.class);

    }

    @GetMapping("/exams")
    public List<ExamDefinition> getExams() {
        return examDefinitionService.getAllExams();
    }

}
