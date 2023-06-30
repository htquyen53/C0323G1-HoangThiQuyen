package customer.controller;

import customer.model.Customer;
import customer.service.CustomerService;
import customer.service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer-list")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService CUSTOMER_SERVICE = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = CUSTOMER_SERVICE.showCustomers();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer-list.jsp");
        requestDispatcher.forward(request,response);
    }
}
