package com.codeclan.course_booking_system.course_booking_system.controller;

import com.codeclan.course_booking_system.course_booking_system.models.Course;
import com.codeclan.course_booking_system.course_booking_system.models.Customer;
import com.codeclan.course_booking_system.course_booking_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value="/customers/course")
    public ResponseEntity<List<Customer>> findCustomersByCourseId(
            @RequestParam(name = "id") Long course_id
    )
    {
        return new ResponseEntity<>(customerRepository.findByBookings_Course_Id(course_id), HttpStatus.OK);
    }

    @GetMapping(value="/customers/town")
    public ResponseEntity<List<Customer>> findCustomersByCourseTown(
            @RequestParam(name = "name") String course_town
    )
    {
        return new ResponseEntity<>(customerRepository.findByBookings_Course_TownIgnoreCase(course_town), HttpStatus.OK);
    }

    //we can query this on the browser at http://localhost:8080/customers/AgeAndCourseTown?age=28&&name=Edinburgh
    @GetMapping(value="/customers/AgeAndCourseTown")
    public ResponseEntity<List<Customer>> findCustomersByAgeAndCourseTown(
            @RequestParam(name = "age") int age, @RequestParam(name = "name") String course_town
    )
    {
        return new ResponseEntity<>(customerRepository.findByAgeAndBookings_Course_TownIgnoreCase(age, course_town), HttpStatus.OK);
    }

}