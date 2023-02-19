package com.vega.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vega.api.model.Rule;

public interface RuleRepository extends MongoRepository<Rule, String> {

}
