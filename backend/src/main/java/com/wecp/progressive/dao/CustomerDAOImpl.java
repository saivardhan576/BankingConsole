package com.wecp.progressive.dao;

import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Customers;

import java.util.ArrayList;
import java.util.List;


public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> customers = new ArrayList<>();
        return  customers;
    }

    @Override
    public Customers getCustomerById(int customerId) {
        return  null;
    }

    @Override
    public int addCustomer(Customers customers) {
        int generatedID = -1;
        return generatedID;
    }

    @Override
    public void updateCustomer(Customers customers) {

    }

    @Override
    public void deleteCustomer(int customerId) {

    }

    @Override
    public CustomerAccountInfo getCustomerAccountInfo(int customerId) {
        return null;
    }

}