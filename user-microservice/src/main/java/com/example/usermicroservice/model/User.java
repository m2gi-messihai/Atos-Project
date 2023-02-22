package com.example.usermicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "User")
@Data
@NoArgsConstructor
public class User {
    @Id
    private String uid;
    private String firstName;
    private String lastName;
    private Role[] roles;
    private String birthDate;
    private String gender;
    private String email;
    private String mobileNumber;
    private String address;

}