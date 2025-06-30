package com.codegym.web_service_va_restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codegym.web_service_va_restful.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
