package com.epam.travel.service;

import com.epam.travel.dao.HotelDAO;
import com.epam.travel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelDAO hotelDAO;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelDAO.getAllHotels();
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotelDAO.addHotel(hotel);
    }

    @Override
    public Hotel findHotel(int id) {
        return hotelDAO.findHotel(id);
    }
}
