package com.codegym.web_service_va_restful.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codegym.web_service_va_restful.model.Customer;
import com.codegym.web_service_va_restful.service.ICustomerService;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable("id") Long id) {
        Customer recentCustomer = customerService.findById(id);
        if (recentCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(recentCustomer, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

        if (customer.getId() != null) {
            return new ResponseEntity<String>("Cannot create customer with existing ID. Please use PUT for updates.",
                    HttpStatus.BAD_REQUEST);
        }

        Customer savedCustomer = customerService.save(customer);

        if (savedCustomer == null) {
            return new ResponseEntity<String>("Failed to create customer due to internal error or invalid data.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCustomer.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Customer currentCustomer = customerService.findById(id);

        if (currentCustomer == null) {

            return new ResponseEntity<String>("Customer with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }

        if (customer.getId() != null && !customer.getId().equals(id)) {
            return new ResponseEntity<String>("ID in path variable does not match ID in request body.",
                    HttpStatus.BAD_REQUEST);
        }

        customer.setId(id);

        Customer updatedCustomer = customerService.save(customer);

        if (updatedCustomer == null) {
            return new ResponseEntity<String>("Failed to update customer due to internal error or invalid data.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);

        if (customer == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}