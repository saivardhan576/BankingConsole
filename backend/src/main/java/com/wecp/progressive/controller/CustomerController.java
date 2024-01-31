package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customers>>  getAllCustomers()
    {
        try {
            List<Customers> list = customerService.getAllCustomers();
            return new ResponseEntity<>(list,HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customers/{customerID}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerID)
    {
        try {
            Customers customers = customerService.getCustomerById(customerID);
            return new ResponseEntity<>(customers,HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers)
    {
        try {
            Integer id = customerService.addCustomer(customers);
            return new ResponseEntity<>(id,HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/customers/{customerID}")
    public void updateCustomer(@PathVariable int customerID,@RequestBody Customers updatedCustomers)
    {
        try {
            customerService.updateCustomer(updatedCustomers);
        } catch (SQLException e) {
        }
    }

    @DeleteMapping("/customers/{customerID}")
    public  void deleteCustomers(@PathVariable int customerID)
    {
        try {
            customerService.deleteCustomer(customerID);
        } catch (SQLException e) {
        }
    }

    @GetMapping("/customers/fromArrayList")
    public ResponseEntity<List<Customers>> getAllCustomersFromArrayList()
    {
        List<Customers> list = customerService.getAllCustomersFromArrayList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/customers/toArrayList")
    public ResponseEntity<List<Customers>> addCustomersToArrayList(@RequestBody Customers customers)
    {
        List<Customers> list = customerService.addCustomersToArrayList(customers);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/customers/fromArrayList/{customerId}")
    public ResponseEntity<List<Customers>> getAllCustomersSortedByNameFromArrayList()
    {
        List<Customers> list = customerService.getAllCustomersSortedByNameFromArrayList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}