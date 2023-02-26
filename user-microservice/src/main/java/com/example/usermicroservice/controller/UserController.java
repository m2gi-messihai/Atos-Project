package com.example.usermicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.service.UserService;
import com.example.usermicroservice.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/registration")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userService.createUser(user);
        return modelMapper.map(user, UserDto.class);

    }

    @GetMapping("/students")
    public List<UserDto> getStudents() {
        List<User> students = userService.getStudents();
        List<UserDto> studentsDto = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            UserDto userdto = modelMapper.map(students.get(i), UserDto.class);
            studentsDto.add(userdto);
        }
        return studentsDto;
    }

}
