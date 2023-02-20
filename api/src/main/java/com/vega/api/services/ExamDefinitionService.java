package com.vega.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vega.api.model.ExamDefinition;
import com.vega.api.repository.ExamDefinitionRepository;

@Service
public class ExamDefinitionService {
    @Autowired
    private ExamDefinitionRepository examDefinitionRepository;

    public ExamDefinition createExamDefinition(ExamDefinition examDefinition) {
        return examDefinitionRepository.save(examDefinition);
    };

}
