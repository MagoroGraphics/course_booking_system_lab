package com.codeclan.course_booking_system.course_booking_system.repository;

import com.codeclan.course_booking_system.course_booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookings_Course_Id(Long id);

    List<Customer> findByBookings_Course_TownIgnoreCase(String town);

    List<Customer> findByAgeAndBookings_Course_TownIgnoreCase(int age, String town);
}
