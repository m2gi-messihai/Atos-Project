package com.vega.api.services;

import org.springframework.stereotype.Service;

import com.vega.api.model.User;
import com.vega.api.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    };

    public User createUser(User user) {
        return userRepository.save(user);
    };

}
