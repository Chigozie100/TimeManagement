package com.example.demo.Service;

import com.example.demo.Entity.User;

import java.util.Optional;

public interface IUserService {
    void saveUser(User user);
    Optional<User> getUserByEmailAndPassword(String email, String password);
    User getUserByEmail(String email);
}
