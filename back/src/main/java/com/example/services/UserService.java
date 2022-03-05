package com.example.services;

import java.util.List;

import com.example.modules.User;
import com.example.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private UserRepo ur;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepo ur) {
        this.ur = ur;
    }

    public User register(User u) {
        return ur.save(u);
    }

    public User Login(String username, String password) {
        return ur.findByUsernameAndPassword(username, password);
    }

    public List<User> getAllUsers() {
        return ur.findAll();
    }

    public User update(User u) {
        return ur.save(u);
    }
}
