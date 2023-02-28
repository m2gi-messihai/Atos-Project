package com.example.exammicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.exammicroservice.dto.ExamInstanceDto;
import com.example.exammicroservice.model.ExamInstance;

public interface ExamInstanceRepository extends MongoRepository<ExamInstance, String> {

}
