package com.epam.travel.service;

import com.epam.travel.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    User findUser(int id);
}
