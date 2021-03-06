package com.epam.travel.controller;

import com.epam.travel.model.*;
import com.epam.travel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourController {

    @Autowired
    UserService userService;
    @Autowired
    HotelService hotelService;
    @Autowired
    AgentService agentService;
    @Autowired
    BookingService bookingService;
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

    @RequestMapping("/hotel")
    public String getHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        for (Hotel hotel :
                hotels) {
            System.out.println(hotel);
        }
        return String.valueOf(hotels);
    }

    @RequestMapping("/agent")
    public String getAgents() {
        List<Agent> agents = agentService.getAllAgents();
        for (Agent agent :
                agents) {
            System.out.println(agent);
        }
        return String.valueOf(agents);
    }

    @RequestMapping("/relation")
    public String getRelations() {
        List<AgentHotelRelation> relations = relationService.getAllRelations();
        for (AgentHotelRelation relation : relations) {
            System.out.println(relation.getId() + " " + relation.getAgent() + " " + relation.getHotel());
        }
        return String.valueOf(relations);
    }

    @RequestMapping("/booking")
    public String getBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
        return String.valueOf(bookings);
    }
}
