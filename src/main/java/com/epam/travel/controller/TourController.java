package com.epam.travel.controller;

import com.epam.travel.dao.RelationDAO;
import com.epam.travel.model.Hotel;
import com.epam.travel.model.User;
import com.epam.travel.service.HotelService;
import com.epam.travel.service.RelationService;
import com.epam.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourController {

    @Autowired
    UserService userService;

    @Autowired
    RelationService relationService;

    @RequestMapping("/")
    public String getIndex() {
        List<User> users = userService.getAllUsers();
        for (User user :
                users) {
            System.out.println(user);
        }
        return String.valueOf(users);
    }

    @Autowired
    HotelService hotelService;

    @RequestMapping("/hotel")
    public String getHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        for (Hotel hotel :
                hotels) {
            System.out.println(hotel);
        }
        return String.valueOf(hotels);
    }

}
