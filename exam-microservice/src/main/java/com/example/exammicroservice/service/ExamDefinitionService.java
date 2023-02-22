package com.example.exammicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.exammicroservice.model.ExamDefinition;
import com.example.exammicroservice.repository.ExamDefinitionRepository;

@Service
public class ExamDefinitionService {
    @Autowired
    private ExamDefinitionRepository examDefinitionRepository;

    public ExamDefinition createExamDefinition(ExamDefinition examDefinition) {
        return examDefinitionRepository.save(examDefinition);
    };

    public ExamDefinition addNewQuestion(String id, String[] questionId) {
        Optional<ExamDefinition> existingExam = examDefinitionRepository.findById(id);
        if (existingExam.isPresent()) {
            existingExam.get().setQuestionsIds(questionId);
            return examDefinitionRepository.save(existingExam.get());
        }
        return null;

    };

    public List<ExamDefinition> getAllExams() {
        return examDefinitionRepository.findAll();
    }

    public Optional<ExamDefinition> getExamById(String id) {
        return examDefinitionRepository.findById(id);
    }

}
