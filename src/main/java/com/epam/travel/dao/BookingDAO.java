package com.epam.travel.dao;

import com.epam.travel.model.Booking;

import java.util.List;

public interface BookingDAO {
    List<Booking> getAllBookings();

    void addBooking(Booking booking);

    Booking findBooking(int id);
}
