package com.customers_management.service;

import com.customers_management.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer);
    void remove (int id);
}
