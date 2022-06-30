package com.codeclan.course_booking_system.course_booking_system.components;

import com.codeclan.course_booking_system.course_booking_system.repository.BookingRepository;
import com.codeclan.course_booking_system.course_booking_system.repository.CourseRepository;
import com.codeclan.course_booking_system.course_booking_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!=test")
@Component
public class DataLoader {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

}
