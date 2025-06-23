package com.example.customer.service;

import com.example.customer.model.Customer;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
}
