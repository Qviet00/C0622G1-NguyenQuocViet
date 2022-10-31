package com.example.controller;


import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.service.impl.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/customer")
public class CustomerContrller {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> customerList = customerService.finddAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(customerList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable int id, @RequestBody Customer customer
    ) {
        Optional<Customer> currentCustomer = customerService.findById(id);
        if (currentCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        customer.setId(currentCustomer.get().getId());
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
        Customer customer = customerService.findById(id).get();
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
