package com.customers_management.service;

import com.customers_management.model.Customer;
import com.customers_management.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        iCustomerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.remove(id);
    }
}
