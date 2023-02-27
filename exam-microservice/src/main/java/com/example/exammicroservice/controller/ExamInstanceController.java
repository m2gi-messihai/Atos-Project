package com.example.exammicroservice.controller;

import java.util.ArrayList;
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

import com.example.exammicroservice.dto.ExamInstanceDto;
import com.example.exammicroservice.model.ExamInstance;
import com.example.exammicroservice.model.ExamQuestion;
import com.example.exammicroservice.service.ExamInstanceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/exams")
public class ExamInstanceController {
    @Autowired
    private ExamInstanceService examInstanceService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/assignExam")
    public ExamInstanceDto assignExamToStudent(@RequestBody ExamInstance examInstance) {
        return modelMapper.map(examInstanceService.assignExamToStudent(examInstance),
                ExamInstanceDto.class);
    }

    @PatchMapping("/{id}/takeExam")
    public ExamInstanceDto takeExam(@PathVariable String id, @RequestBody ExamQuestion[] questionsIds) {
        return modelMapper.map(examInstanceService.takeExam(id, questionsIds), ExamInstanceDto.class);
    }

    @GetMapping("/assignedExams")
    public List<ExamInstanceDto> getAssignedExams() {
        List<ExamInstance> examInstances = examInstanceService.getAssignedExam();
        List<ExamInstanceDto> examInstanceDtos = new ArrayList<>();
        for (int i = 0; i < examInstances.size(); i++) {
            ExamInstanceDto examInstanceDto = modelMapper.map(examInstances.get(i), ExamInstanceDto.class);
            examInstanceDtos.add(examInstanceDto);
        }
        return examInstanceDtos;

    }

}
