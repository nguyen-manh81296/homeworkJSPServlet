package com.example.homework.controller;

import com.example.homework.entity.Customer;
import com.example.homework.model.CustomerModel;
import com.example.homework.model.MysqlCustomerModel;
import com.example.homework.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class ListCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public ListCustomerServlet() {
        this.customerModel = new MysqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //trả về form.
        req.setAttribute("customer",new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/list.jsp").forward(req, resp);
    }


}
