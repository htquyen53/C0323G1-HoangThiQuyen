package com.example.simple_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "CaculatorServlet", value = "/simple-calculator")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("first operand"));
        double secondOperand = Double.parseDouble(request.getParameter("second operand"));
        char operator = request.getParameter("operator").charAt(0);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Result: </h1>");
        double result = 0;
        switch (operator) {
            case ('+'):
                result = firstOperand + secondOperand;
                writer.println(firstOperand + " " + operator + " " + secondOperand + " =" + result);
                break;
            case ('-'):
                result = firstOperand - secondOperand;
                writer.println(firstOperand + " " + operator + " " + secondOperand + " =" + result);
                break;
            case ('*'):
                result = firstOperand * secondOperand;
                writer.println(firstOperand + " " + operator + " " + secondOperand + " =" + result);
                break;
            case ('/'):
                try {
                    result = firstOperand / secondOperand;
                } catch (Exception e) {
                    writer.println("Error: " + e.getMessage());
                }
                writer.println(firstOperand + " " + operator + " " + secondOperand + " =" + result);
                break;
            default:
                writer.println("You enter wrong operator format!");
        }
        writer.println("</html>");
    }
}
