package com.epam.travel.service;

import com.epam.travel.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User findUser(int id);
}
