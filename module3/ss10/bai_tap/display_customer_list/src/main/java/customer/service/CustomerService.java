package customer.service;

import customer.model.Customer;
import customer.repository.ICustomerRepository;
import customer.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private static final ICustomerRepository REPOSITORY = new CustomerRepository();
    private static final List<Customer> CUSTOMER_LIST = REPOSITORY.getAll();
    @Override
    public List<Customer> showCustomers() {
        return CUSTOMER_LIST;
    }
}
