package com.codeclan.course_booking_system.course_booking_system.repository;

import com.codeclan.course_booking_system.course_booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
