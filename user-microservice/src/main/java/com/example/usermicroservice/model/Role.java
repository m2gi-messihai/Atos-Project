package com.example.usermicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Role")
@Data
@NoArgsConstructor
public class Role {
    @Id
    String roleId;
    String name;
    String description;

}
