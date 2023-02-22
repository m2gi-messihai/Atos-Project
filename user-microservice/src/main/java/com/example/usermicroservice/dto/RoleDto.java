package com.example.usermicroservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {

    String roleId;
    String name;
    String description;

}
