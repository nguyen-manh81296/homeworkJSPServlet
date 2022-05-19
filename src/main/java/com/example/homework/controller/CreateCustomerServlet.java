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

public class CreateCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public CreateCustomerServlet() {
        this.customerModel = new MysqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        String phone = req.getParameter("phone");
        String stringBirthday = req.getParameter("birthday");
        System.out.println(name);
        LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Customer customer = new Customer(id, name, image, phone, birthday);
        // validate dữ liệu
        if (customerModel.save(customer) != null) {
            resp.sendRedirect("/admin/customers/list");
        } else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }
}
