package com.example.usermicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.usermicroservice.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{email:?0}")
    public User findByEmail(String email);

    @Query(value = "{mobileNumber:?0}")
    public User findByMobileNumber(String mobileNumber);

}
