package com.example.exammicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.exammicroservice.model.ExamDefinition;

public interface ExamDefinitionRepository extends MongoRepository<ExamDefinition, String> {

}
