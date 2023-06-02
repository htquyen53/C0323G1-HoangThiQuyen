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
    public void edit(Customer customer) {
        customerList = getAll();
        for (int i = 0; i < customerList.size(); i++) {
            if (customer.getId().equals(customerList.get(i).getId())) {
                customerList.set(i,customer);
            }
        }
//        for (Customer temp : customerList) {
//            if (temp.getId().equals(customer.getId())) {
//                temp.setName(customer.getName());
//                temp.setBirthday(customer.getBirthday());
//                temp.setGender(customer.isGender());
//                temp.setCitizenID(customer.getCitizenID());
//                temp.setNumberPhone(customer.getNumberPhone());
//                temp.setEmail(customer.getEmail());
//                temp.setTypeCustomer(customer.getTypeCustomer());
//                temp.setAddress(customer.getAddress());
//            }
//        }
        List<String> customerStr = new ArrayList<>();
        for (Customer temp : customerList) {
            customerStr.add(getInfoToCSV(temp));
            ReadAndWriteCSV.writeFile(customerStr, CUSTOMERS_LIST_PATH, false);
        }
    }

        @Override
        public void delete (Customer customer){
            customerList = getAll();
            customerList.remove(customer);
            List<String> strings = new ArrayList<>();
            for (Customer e : customerList) {
                strings.add(getInfoToCSV(e));
            }
            ReadAndWriteCSV.writeFile(strings, CUSTOMERS_LIST_PATH, false);
        }

        @Override
        public Customer findByID (String id){
            customerList = getAll();
            for (Customer customer : customerList) {
                if (customer.getId().equals(id)) {
                    return customer;
                }
            }
            return null;
        }

        @Override
        public List<Customer> findByName (String name){
            return null;
        }

        public String getInfoToCSV (Customer customer){
            return customer.getId() + "," + customer.getName() + "," + customer.getBirthday() + "," + customer.isGender()
                    + "," + customer.getCitizenID() + "," + customer.getNumberPhone() + "," + customer.getEmail()
                    + "," + customer.getTypeCustomer() + "," + customer.getAddress();
        }
    }
