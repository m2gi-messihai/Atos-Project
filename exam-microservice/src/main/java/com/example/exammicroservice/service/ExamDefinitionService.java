package com.example.exammicroservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.exammicroservice.model.ExamDefinition;
import com.example.exammicroservice.repository.ExamDefinitionRepository;

@Service
public class ExamDefinitionService {
    private Logger log = LoggerFactory.getLogger(ExamDefinitionService.class);
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
        } else {

            return null;
        }

    };

    public List<ExamDefinition> getAllExams() {
        return examDefinitionRepository.findAll();
    }

    public ExamDefinition getExamById(String id) {
        Optional<ExamDefinition> examDefinition = examDefinitionRepository.findById(id);
        if (examDefinition.isPresent()) {
            return examDefinition.get();
        } else {
            log.debug("id is " + id);
            return null;
        }

    }

}
