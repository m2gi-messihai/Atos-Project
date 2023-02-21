package com.vega.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vega.api.dto.RoleDto;
import com.vega.api.model.Role;
import com.vega.api.services.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/roleForm")
    public RoleDto createRole(@RequestBody RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        roleService.createRole(role);
        return modelMapper.map(role, RoleDto.class);
    }

    @GetMapping("/roles")
    public List<RoleDto> getRoles() {
        List<Role> roles = roleService.getRoles();
        List<RoleDto> rolesDto = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            RoleDto roleDto = modelMapper.map(roles.get(i), RoleDto.class);
            rolesDto.add(roleDto);
        }
        return rolesDto;
    }

}
