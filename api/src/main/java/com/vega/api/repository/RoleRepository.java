package com.vega.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vega.api.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}
