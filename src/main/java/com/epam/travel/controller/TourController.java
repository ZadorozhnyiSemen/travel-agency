package com.epam.travel.controller;

import com.epam.travel.dao.UserDAOImpl;
import com.epam.travel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourController {

    @Autowired
    UserDAOImpl userDAO;

    @RequestMapping("/")
    public String getIndex() {
        List<User> list = userDAO.getAllUsers();
        for (User user : list) {
            System.out.println(user.toString());
        }
        return "Hello";
    }

}
