package case_study.furama_resort.repository;

import case_study.furama_resort.common.ReadAndWriteCSV;
import case_study.furama_resort.model.human.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    private static final String CUSTOMERS_LIST_PATH = "module2/src/case_study/furama_resort/data/customer.csv";

    //Customer(String id, String name, String birthday, boolean gender, String citizenID, String numberPhone, String email, String typeCustomer, String address)
    @Override
    public List<Customer> getAll() {
        List<String> customerStr = ReadAndWriteCSV.readFile(CUSTOMERS_LIST_PATH);
        customerList.clear();
        String[] info;
        for (String str : customerStr) {
            info = str.split(",");
            customerList.add(new Customer(info[0], info[1], info[2], Boolean.parseBoolean(info[3]), info[4], info[5], info[6], info[7], info[8]));
        }
        return customerList;
    }

    @Override
    public void addNew(Customer customer) {
        List<String> customerStr = new ArrayList<>();
        customerStr.add(getInfoToCSV(customer));
        ReadAndWriteCSV.writeFile(customerStr, CUSTOMERS_LIST_PATH, true);
    }

    @Override
    public Customer getByID(String id) {
        customerList = getAll();
        for (Customer customer: customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void edit(String id) {
        customerList = getAll();
        List<String> customerStr = new ArrayList<>();
        for (Customer customer: customerList) {
            if(customer.getId().equals(id)) {
                customer.setName(customer.getName());
                customer.setBirthday(customer.getBirthday());
                customer.setGender(customer.isGender());
                customer.setCitizenID(customer.getCitizenID());
                customer.setNumberPhone(customer.getNumberPhone());
                customer.setEmail(customer.getEmail());
                customer.setTypeCustomer(customer.getTypeCustomer());
                customer.setAddress(customer.getAddress());
                customerStr.add(getInfoToCSV(customer));
            } customerStr.add(getInfoToCSV(customer));
        }
        ReadAndWriteCSV.writeFile(customerStr, CUSTOMERS_LIST_PATH, false);
    }


    public String getInfoToCSV(Customer customer) {
        return customer.getId() + "," + customer.getName() + "," + customer.getBirthday() + "," + customer.isGender()
                + "," + customer.getCitizenID() + "," + customer.getNumberPhone() + "," + customer.getEmail()
                + "," + customer.getTypeCustomer() + "," + customer.getAddress();
    }
}
