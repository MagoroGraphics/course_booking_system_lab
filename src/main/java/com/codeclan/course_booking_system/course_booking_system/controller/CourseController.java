package com.codeclan.course_booking_system.course_booking_system.controller;

import com.codeclan.course_booking_system.course_booking_system.models.Course;
import com.codeclan.course_booking_system.course_booking_system.models.Customer;
import com.codeclan.course_booking_system.course_booking_system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value="/courses/rating")
    public ResponseEntity<List<Course>> findCoursesByRating(
            @RequestParam(name = "rating") int rating
    )
    {
        return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
    }

}
