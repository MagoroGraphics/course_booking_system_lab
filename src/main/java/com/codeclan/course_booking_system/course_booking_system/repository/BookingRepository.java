package com.codeclan.course_booking_system.course_booking_system.repository;

import com.codeclan.course_booking_system.course_booking_system.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDate(String date);



}
