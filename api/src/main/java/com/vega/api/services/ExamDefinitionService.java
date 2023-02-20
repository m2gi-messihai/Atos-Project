package com.vega.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vega.api.dto.GetAllExamResponseDto;
import com.vega.api.model.ExamDefinition;
import com.vega.api.repository.ExamDefinitionRepository;

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

}
