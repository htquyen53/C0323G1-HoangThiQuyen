package com.customers_management.repository;

import com.customers_management.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
