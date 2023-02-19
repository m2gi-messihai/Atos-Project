package com.vega.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vega.api.model.ExamDefinition;

public interface ExamDefinitionRepository extends MongoRepository<ExamDefinition, String> {

}
