package com.example.usermicroservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.usermicroservice.model.User;
import com.example.usermicroservice.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    };

    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null
                && userRepository.findByMobileNumber(user.getMobileNumber()) == null) {
            return userRepository.save(user);
        } else {
            return null;
        }
    };

    public List<User> getStudents() {
        return this.userRepository.findStudents();
    }

    public List<User> getTeachers() {
        return this.userRepository.findTeachers();

    }

}
