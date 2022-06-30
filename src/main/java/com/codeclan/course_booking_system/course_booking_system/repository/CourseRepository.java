package com.codeclan.course_booking_system.course_booking_system.repository;

import com.codeclan.course_booking_system.course_booking_system.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);

    List<Course> findByBookings_Customer_Id(Long id);



}
