package com.vega.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vega.api.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    @Query(value = "{name:?0}")
    public Role findByName(String name);

}
