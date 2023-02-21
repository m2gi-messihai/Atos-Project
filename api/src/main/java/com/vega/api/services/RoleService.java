package com.vega.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vega.api.model.Role;
import com.vega.api.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        if (roleRepository.findByName(role.getName()) == null) {
            return roleRepository.save(role);
        } else {
            return null;
        }
    };

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

}
