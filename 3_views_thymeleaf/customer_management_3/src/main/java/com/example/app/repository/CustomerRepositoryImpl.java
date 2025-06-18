package com.example.app.repository;

import com.example.app.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final Map<Long, Customer> customers;
    private static final AtomicLong idCounter;

    static {
        customers = new HashMap<>();
        idCounter = new AtomicLong();
        customers.put(idCounter.incrementAndGet(), new Customer(1L, "Nguyễn Văn A", "a.nguyen@codegym.vn", "Hà Nội"));
        customers.put(idCounter.incrementAndGet(), new Customer(2L, "Trần Thị B", "b.tran@codegym.vn", "Đà Nẵng"));
        customers.put(idCounter.incrementAndGet(), new Customer(3L, "Phạm Văn C", "c.pham@codegym.vn", "TP.HCM"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
        Long id = customer.getId();
        if (id == null || id == 0) {
            Long nid = idCounter.getAndIncrement();
            customer.setId(nid);
            customers.put(nid, customer);
        }
        else {
            customers.put(id, customer);
        }
    }

    @Override
    public void remove(Long id) {
        customers.remove(id);
    }
}
