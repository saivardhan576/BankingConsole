package com.wecp.progressive.service;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.repository.CustomerRepository;
 
@Service
public class CustomerServiceImplJpa implements CustomerService{
   
    @Autowired
    private CustomerRepository customerRepository;
   
    private static List<Customers> customersList = new ArrayList<>();
    public CustomerServiceImplJpa(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
 
 
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customerRepository.findAll();
    }
 
    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        return customerRepository.findById(customerId).get();
    }
 
    @Override
    public int addCustomer(Customers customers) throws SQLException {
       
       customerRepository.save(customers);
       return customers.getCustomerId();
    }
 
    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        customerRepository.findById(customers.getCustomerId()).map(customer ->{
            customer.setName(customers.getName());
            customer.setEmail(customers.getEmail());
            customer.setUsername(customers.getUsername());
            customer.setPassword(customers.getPassword());
            return customerRepository.save(customer);
        });
       
    }
 
    @Override
    public void deleteCustomer(int customerId) throws SQLException {
       customerRepository.deleteById(customerId);
    }
 
    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
       
        return null;
    }
 
    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        return customersList;
    }
 
    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        customersList.add(customers);
        return customersList;
    }
 
    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList(){
        List<Customers> sortedCustomers = customersList;
        Collections.sort(sortedCustomers);
        return sortedCustomers;
    }
 
    @Override
    public void emptyArrayList() {
        customersList = new ArrayList<>();
    }
}