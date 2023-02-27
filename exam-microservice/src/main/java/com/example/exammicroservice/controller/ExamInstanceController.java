package com.example.exammicroservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exammicroservice.dto.ExamInstanceDto;
import com.example.exammicroservice.model.ExamInstance;
import com.example.exammicroservice.model.GeneratedLink;
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

}
