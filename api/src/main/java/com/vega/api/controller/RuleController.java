package com.vega.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vega.api.dto.RuleDto;
import com.vega.api.model.Rule;
import com.vega.api.services.RuleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class RuleController {
    @Autowired
    private RuleService ruleService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/ruleForm")
    public RuleDto createUser(@RequestBody RuleDto ruleDto) {
        Rule rule = modelMapper.map(ruleDto, Rule.class);
        ruleService.createRule(rule);
        return modelMapper.map(rule, RuleDto.class);
    }

}
