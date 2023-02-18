package com.vega.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vega.api.dto.UserDto;
import com.vega.api.model.User;
import com.vega.api.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/registration")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User x = userService.createUser(user);
        return modelMapper.map(x, UserDto.class);

    }

}
