package com.example.homework.model;

import com.example.homework.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel {

    private static List<Customer> customers;

    public InMemoryCustomerModel() {
        customers = new ArrayList<>();
        customers.add(
                new Customer("AB1",
                        "Manh",
                        "098754224",
                        "adj.jpg",
                        LocalDateTime.of(2002, 3, 29, 10, 10),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer("AB2",
                        "Minh",
                        "03233443232",
                        "adj5.jpg",
                        LocalDateTime.of(2002, 4, 28, 10, 10),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "AB3",
                        "My",
                        "6767676876",
                        "adj5.jpg",
                        LocalDateTime.of(2002, 5, 27, 9, 2),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );

    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String id) {
        Customer foundCustomer = null;
        for (Customer customer :
                customers) {
            if (customer.getId().equals(id)) {
                foundCustomer = customer;
                break;
            }

        }
        return foundCustomer;
    }

    @Override
    public Customer update(String id, Customer updateCustomer) {
        Customer existingCustomer = findById(id);
        if (existingCustomer == null) {
            return null;
        }
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setImage(updateCustomer.getImage());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setCreateAt(LocalDateTime.now());
        existingCustomer.setUpdateAt(LocalDateTime.now());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;

    }

    @Override
    public boolean delete(String id) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(id)) {
                foundIndex = i;
            }
        }
        if (foundIndex != -1) {
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }

}
