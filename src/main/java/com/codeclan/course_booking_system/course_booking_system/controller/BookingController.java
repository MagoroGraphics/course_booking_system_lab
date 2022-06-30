package com.codeclan.course_booking_system.course_booking_system.controller;

import com.codeclan.course_booking_system.course_booking_system.models.Booking;
import com.codeclan.course_booking_system.course_booking_system.models.Course;
import com.codeclan.course_booking_system.course_booking_system.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;


    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value="/bookings/date")
    public ResponseEntity<List<Booking>> findBookingsByDate(
            @RequestParam(name = "param") String date
    )
    {
        return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
    }

}
