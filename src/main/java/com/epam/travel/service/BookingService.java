package com.epam.travel.service;

import com.epam.travel.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();

    void addBooking(Booking booking);

    Booking findBooking(int id);
}
