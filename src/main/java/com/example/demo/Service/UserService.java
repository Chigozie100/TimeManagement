package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.getUserByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
