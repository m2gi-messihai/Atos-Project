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

import com.example.exammicroservice.dto.ExamInstanceDto;
import com.example.exammicroservice.dto.GetAssignedExamNameDto;
import com.example.exammicroservice.dto.QuestionDto;
import com.example.exammicroservice.model.ExamInstance;
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

    @GetMapping("/questions/{id}")
    public QuestionDto getQuestions(@PathVariable String id) {
        return examInstanceService.getQuestions(id);
    }

    @GetMapping("/assignedExams")
    public List<GetAssignedExamNameDto> getAssignedExamName() {
        return examInstanceService.getAssignedExamName();

    }

    @PatchMapping("/startExam/{id}")
    public ExamInstance startExam(@PathVariable String id, @RequestBody String date) {
        return examInstanceService.setStartedTime(id, date);
    }

    @GetMapping("/assignedExams/{id}")
    public GetAssignedExamNameDto getAssignedExamById(@PathVariable String id) {
        return examInstanceService.getAssignedExamById(id);
    }

    @GetMapping("/assignedExams/{examId}/questions/{questionId}")
    public QuestionDto getQuestionForExam(@PathVariable String examId, @PathVariable String questionId) {
        return examInstanceService.getQuestionForExam(examId, questionId);
    }

}
