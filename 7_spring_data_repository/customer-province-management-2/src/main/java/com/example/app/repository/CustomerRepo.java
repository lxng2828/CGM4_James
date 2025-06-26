package com.example.app.repository;

import com.example.app.model.Customer;
import com.example.app.model.Province;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findAllByProvince(Province province);
}
