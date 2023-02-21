package com.vega.api.dto;

import lombok.Data;

@Data
public class UserDto {

    private String uid;
    private String firstName;
    private String lastName;
    private RoleDto[] roles;
    private String birthDate;
    private String gender;
    private String email;
    private String mobileNumber;
    private String address;

}
