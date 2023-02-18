package com.vega.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vega.api.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
