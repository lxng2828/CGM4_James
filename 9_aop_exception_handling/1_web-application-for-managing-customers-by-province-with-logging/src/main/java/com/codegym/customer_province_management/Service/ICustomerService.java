package com.codegym.customer_province_management.Service;

import com.codegym.customer_province_management.model.Customer;
import com.codegym.customer_province_management.model.Province;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvice(Province province);
}
