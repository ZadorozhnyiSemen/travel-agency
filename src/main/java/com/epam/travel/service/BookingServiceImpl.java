package com.epam.travel.service;

import com.epam.travel.dao.BookingDAO;
import com.epam.travel.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingDAO bookingDAO;

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @Override
    public void addBooking(Booking booking) {
        bookingDAO.addBooking(booking);
    }

    @Override
    public Booking findBooking(int id) {
        return bookingDAO.findBooking(id);
    }
}
