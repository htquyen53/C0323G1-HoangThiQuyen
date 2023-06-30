package customer.repository;

import customer.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer> CUSTOMER_LIST = new ArrayList<>();

    static {
        CUSTOMER_LIST.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLTaeJp7_7Styy4qG54XznDX58OwYEMTDbmQ&usqp=CAU"));
        CUSTOMER_LIST.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtfHAdwz7l0FPX36oQ1vKfsmIxn0wV9s7baA&usqp=CAU"));
        CUSTOMER_LIST.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://www.southernliving.com/thmb/t4CDcQzE1dJvfCt2VTHt3yRoCNc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/valentine-bouquet-gettyimages-55949391-2000-d675e30abd0243f1bf1d13ecb212d45b.jpg"));
        CUSTOMER_LIST.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://i.ytimg.com/vi/PVnKIXogfaA/maxresdefault.jpg"));
        CUSTOMER_LIST.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://media.interflora.co.uk/i/interflora/HPHTU1E-1.jpg?$poi-square$&fmt=auto&qlt=default&fmt.jp2.qlt=60&bg=rgb%28255%2C+255%2C+255%29&w=1024"));
    }

    @Override
    public List<Customer> getAll() {
        return CUSTOMER_LIST;
    }
}
