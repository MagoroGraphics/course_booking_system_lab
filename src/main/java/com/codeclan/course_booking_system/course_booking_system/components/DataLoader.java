package com.codeclan.course_booking_system.course_booking_system.components;

import com.codeclan.course_booking_system.course_booking_system.models.Booking;
import com.codeclan.course_booking_system.course_booking_system.models.Course;
import com.codeclan.course_booking_system.course_booking_system.models.Customer;
import com.codeclan.course_booking_system.course_booking_system.repository.BookingRepository;
import com.codeclan.course_booking_system.course_booking_system.repository.CourseRepository;
import com.codeclan.course_booking_system.course_booking_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!=test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        Customer customer1 = new Customer("John", "Edinburgh", 28);
        customerRepository.save(customer1);

        Course course1 = new Course("PSD", "Edinburgh", 4);
        courseRepository.save(course1);

        Booking booking1 = new Booking("22/06/2022", course1, customer1);
        bookingRepository.save(booking1);

        Customer customer2 = new Customer("Marta", "DF", 38);
        customerRepository.save(customer2);

        Course course2 = new Course("JS Basics", "DF", 3);
        courseRepository.save(course2);

        Booking booking2 = new Booking("22/06/2023", course2, customer1);
        bookingRepository.save(booking2);


        Customer customer3 = new Customer("Valentina", "Chicago", 18);
        customerRepository.save(customer3);

        Course course3 = new Course("Advanced React", "San Francisco", 5);
        courseRepository.save(course3);

        Booking booking3 = new Booking("12/07/2022", course2, customer2);
        bookingRepository.save(booking3);


        Customer customer4 = new Customer("Federico", "Buenos Aires", 34);
        customerRepository.save(customer4);

        Course course4 = new Course("Basic React", "Glasgow", 4);
        courseRepository.save(course4);

        Booking booking4 = new Booking("10/08/2022", course2, customer4);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("22/08/2022", course1, customer2);
        bookingRepository.save(booking5);


        Booking booking6 = new Booking("20/08/2022", course4, customer1);
        bookingRepository.save(booking6);

        Booking booking7 = new Booking("10/09/2022", course3, customer1);
        bookingRepository.save(booking7);

        customer1.addBookings(booking1);
        customer1.addBookings(booking2);
        customer1.addBookings(booking7);
        customer1.addBookings(booking6);
        customerRepository.save(customer1);

        customer2.addBookings(booking3);
        customer2.addBookings(booking5);
        customerRepository.save(customer2);

        customer3.addBookings(booking3);
        customerRepository.save(customer3);

        customer4.addBookings(booking4);
        customerRepository.save(customer4);

        course1.addBookings(booking1);
        course1.addBookings(booking5);
        courseRepository.save(course1);

        course2.addBookings(booking2);
        course2.addBookings(booking3);
        course2.addBookings(booking4);
        courseRepository.save(course2);

        course3.addBookings(booking7);
        courseRepository.save(course3);

        course4.addBookings(booking6);
        courseRepository.save(course4);

    }
}
