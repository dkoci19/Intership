package com.example.rentcar.service;

import com.example.rentcar.model.User;
import com.example.rentcar.repository.UserRepository;
import com.example.rentcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void  deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
