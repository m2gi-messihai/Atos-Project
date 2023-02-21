package com.vega.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    private RoleService ruleService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/ruleForm")
    public RoleDto createUser(@RequestBody RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        ruleService.createRule(role);
        return modelMapper.map(role, RoleDto.class);
    }

}
