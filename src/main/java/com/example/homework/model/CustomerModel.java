package com.example.homework.model;

import com.example.homework.entity.Customer;

import java.util.List;

public interface CustomerModel {

    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(String id);

    Customer update(String id, Customer updateCustomer);

    boolean delete(String id);
}
