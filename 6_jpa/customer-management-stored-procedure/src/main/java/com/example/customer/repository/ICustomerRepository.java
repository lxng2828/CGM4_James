package com.example.customer.repository;

import com.example.customer.model.Customer;

public interface ICustomerRepository {
    boolean saveWithStoredProcedure(Customer customer);
}
