package com.vega.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vega.api.model.Rule;
import com.vega.api.repository.RuleRepository;

@Service
public class RuleService {
    @Autowired
    private RuleRepository ruleRepository;

    public Rule createRule(Rule rule) {
        return ruleRepository.save(rule);
    };

}
