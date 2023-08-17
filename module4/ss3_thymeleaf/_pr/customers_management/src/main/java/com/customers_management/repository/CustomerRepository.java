package com.customers_management.repository;

import com.customers_management.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@gmail.com", "Đà Nẵng"));
        customers.put(2, new Customer(2, "Mana", "mana@gmail.com", "Đà Nẵng"));
        customers.put(3, new Customer(3, "Eva", "eva@gmail.com", "Hà Nội"));
        customers.put(4, new Customer(4, "Lan", "lan@gmail.com", "Đà Nẵng"));
        customers.put(5, new Customer(5, "An", "an@gmail.com", "Hồ Chí Minh"));
        customers.put(6, new Customer(6, "Bình", "binh@gmail.com", "Đà Nẵng"));

    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
