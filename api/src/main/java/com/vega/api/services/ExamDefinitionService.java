package com.vega.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.vega.api.model.ExamDefinition;
import com.vega.api.repository.ExamDefinitionRepository;

public class ExamDefinitionService {
    @Autowired
    private ExamDefinitionRepository examDefinitionRepository;

    public ExamDefinition createExamDefinition(ExamDefinition examDefinition) {
        return examDefinitionRepository.save(examDefinition);
    };

}
