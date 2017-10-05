package com.epam.travel.service;

import com.epam.travel.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    void addHotel(Hotel hotel);

    Hotel findHotel(int id);
}
