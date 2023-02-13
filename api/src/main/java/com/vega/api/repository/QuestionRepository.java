package com.vega.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vega.api.model.Question;

import java.util.Optional;

import org.bson.types.ObjectId;

public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
    @Query(value = "{key:?0}", delete = true)
    public void deleteById(String id);

    @Query(value = "{key:?0}")
    public Optional<Question> findById(String id);

}
