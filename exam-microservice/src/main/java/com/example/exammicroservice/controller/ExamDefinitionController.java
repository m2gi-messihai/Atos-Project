package com.example.exammicroservice.controller;

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

import com.example.exammicroservice.dto.ExamDefinitionDto;
import com.example.exammicroservice.model.ExamDefinition;
import com.example.exammicroservice.service.ExamDefinitionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/exams")
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

    @GetMapping("")
    public List<ExamDefinition> getExams() {
        return examDefinitionService.getAllExams();
    }

    @GetMapping("/{examId}")
    public ExamDefinitionDto getExamById(@PathVariable String examId) {
        ExamDefinition examDefinition = examDefinitionService.getExamById(examId).get();
        return modelMapper.map(examDefinition, ExamDefinitionDto.class);
    }

}
