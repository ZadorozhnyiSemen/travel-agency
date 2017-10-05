package com.epam.travel.dao;

import com.epam.travel.model.Hotel;

import java.util.List;

public interface HotelDAO {
    List<Hotel> getAllHotels();

    void addHotel(Hotel hotel);

    Hotel findHotel(int id);
}