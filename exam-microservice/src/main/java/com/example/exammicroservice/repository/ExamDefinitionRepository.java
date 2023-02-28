package com.example.exammicroservice.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.exammicroservice.dto.ExamDefinitionDto;
import com.example.exammicroservice.model.ExamDefinition;

public interface ExamDefinitionRepository extends MongoRepository<ExamDefinition, String> {
    // @Query(value = "{examId:?0}")
    // public Optional<ExamDefinition> findByExamId(String examId);

}
