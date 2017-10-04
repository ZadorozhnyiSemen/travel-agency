package com.epam.travel.service;

import com.epam.travel.dao.UserDAO;
import com.epam.travel.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;


    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User findUser(int id) {
        return userDAO.findUser(id);
    }
}
