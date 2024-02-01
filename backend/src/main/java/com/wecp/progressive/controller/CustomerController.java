package com.wecp.progressive.controller;
 
 
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerService;
import com.wecp.progressive.service.CustomerServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.sql.SQLException;
import java.util.List;
 
@RestController
@RequestMapping("/customers")
public class CustomerController {
 
    @Autowired
    CustomerService customerService;
 
    @GetMapping()
    public ResponseEntity<List<Customers>> getAllCustomers() throws SQLException {
        return new ResponseEntity<List<Customers>>(customerService.getAllCustomers(),HttpStatus.OK);
    }
 
    @GetMapping("/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerID) throws SQLException {
        return new ResponseEntity<Customers>(customerService.getCustomerById(customerID),HttpStatus.OK);
    }
 
    @PostMapping()
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) throws SQLException {
        return new ResponseEntity<Integer>(customerService.addCustomer(customers),HttpStatus.CREATED);
    }
 
    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable int customerId, @RequestBody Customers customers) throws SQLException {
        customers.setCustomerId(customerId);
        customerService.updateCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) throws SQLException {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Customers>> getAllCustomersFromArrayList() {
        return new ResponseEntity<List<Customers>>(customerService.getAllCustomersFromArrayList(),HttpStatus.OK);
    }
    @PostMapping("/toArrayList")
    public ResponseEntity<List<Customers>> addCustomerToArrayList(@RequestBody Customers customers) {
        return new ResponseEntity<List<Customers>>(customerService.addCustomersToArrayList(customers),HttpStatus.OK);
    }
 
    @GetMapping("/fromArrayList/{customerId}")
    public ResponseEntity<List<Customers>> getAllCustomersSortedByNameFromArrayList(@PathVariable int customerID) {
        return new ResponseEntity<List<Customers>>(customerService.getAllCustomersSortedByNameFromArrayList(),HttpStatus.OK);
 
    }
 
}
 