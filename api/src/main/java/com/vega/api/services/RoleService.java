package com.vega.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vega.api.model.Role;
import com.vega.api.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role createRule(Role role) {
        return roleRepository.save(role);
    };

}
