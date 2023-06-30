package customer.repository;

import customer.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
}
