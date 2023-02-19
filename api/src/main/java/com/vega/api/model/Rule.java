package com.vega.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Rule")
@Data
@NoArgsConstructor
public class Rule {
    @Id
    String ruleId;
    String name;
    String description;

}
