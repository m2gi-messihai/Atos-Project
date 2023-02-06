package com.vega.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vega.api.model.Question;

import org.bson.types.ObjectId;

public interface QuestionRepository extends MongoRepository<Question, ObjectId> {

}
