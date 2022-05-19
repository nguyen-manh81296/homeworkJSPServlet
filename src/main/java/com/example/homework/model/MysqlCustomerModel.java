package com.example.homework.model;

import com.example.homework.entity.Customer;
import com.example.homework.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MysqlCustomerModel implements CustomerModel {

    @Override
    public Customer save(Customer customer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into customers" +
                    "(id,name,phone,image,dob,creatAt,updateAt,status)" +
                    "values" +
                    "(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,customer.getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getPhone());
            preparedStatement.setString(4,customer.getImage());
            preparedStatement.setString(5,customer.getDob().toString());
            preparedStatement.setString(6,customer.getCreateAt().toString());
            preparedStatement.setString(7,customer.getUpdateAt().toString());
            preparedStatement.setInt(8,customer.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return customer;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customers where status = ?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String image = resultSet.getString("image");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updateAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updateAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Customer customer = new Customer(id, name, phone, image, dob,  createAt, updateAt, status);
                list.add(customer);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer findById(String id) {
        Customer customer = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customers where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String image = resultSet.getString("image");
                String phone = resultSet.getString("phone");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updateAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updateAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                customer = new Customer(id, name, phone, image, dob,  createAt, updateAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
        @Override
                public Customer update(String id,Customer updateCustomer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers" +
                    "set id = ? ,name =?, phone = ?, image = ?,dob = ?, createAt =?, updateAt =?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateCustomer.getId());
            preparedStatement.setString(2, updateCustomer.getName());
            preparedStatement.setString(3, updateCustomer.getPhone());
            preparedStatement.setString(4, updateCustomer.getImage());
            preparedStatement.setString(5, updateCustomer.getDob().toString());
            preparedStatement.setString(6, updateCustomer.getCreateAt().toString());
            preparedStatement.setString(7, updateCustomer.getUpdateAt().toString());
            preparedStatement.setInt(8, updateCustomer.getStatus());
            preparedStatement.setString(9, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setString(2, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
