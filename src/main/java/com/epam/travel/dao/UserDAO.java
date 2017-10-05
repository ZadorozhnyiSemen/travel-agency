package com.epam.travel.dao;

import com.epam.travel.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User user);

    User findUser(int id);
}
