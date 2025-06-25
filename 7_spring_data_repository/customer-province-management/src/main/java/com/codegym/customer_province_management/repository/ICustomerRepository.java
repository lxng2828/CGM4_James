package com.codegym.customer_province_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegym.customer_province_management.model.Customer;
import com.codegym.customer_province_management.model.Province;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
