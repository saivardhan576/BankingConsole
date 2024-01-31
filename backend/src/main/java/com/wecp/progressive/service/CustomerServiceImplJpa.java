package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Customers;

@Service
public class CustomerServiceImplJpa implements CustomerService{

    public List<Customers> list = new ArrayList<>();

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return null;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        return null;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        return -1;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        return null;
    }

    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        return list;
    }

    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        list.add(customers);
        return list;
    }

    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList() {
        List<Customers> sortedList = list;
        Collections.sort(sortedList);
        return sortedList;
    }

    @Override
    public void emptyArrayList() {
        list = new ArrayList<>();
    }
    
}