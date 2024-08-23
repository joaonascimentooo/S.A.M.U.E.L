package com.example.samuel.SAMUEL.service;

import com.example.samuel.SAMUEL.domain.user.User;
import com.example.samuel.SAMUEL.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
