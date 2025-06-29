package com.codegym.aop_exception_handling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codegym.aop_exception_handling.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
}