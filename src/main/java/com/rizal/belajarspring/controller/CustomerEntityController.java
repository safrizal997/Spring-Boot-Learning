package com.rizal.belajarspring.controller;

import com.rizal.belajarspring.entity.CustomerEntity;
import com.rizal.belajarspring.model.CustomerRequest;
import com.rizal.belajarspring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerEntityController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerEntity> getCustomers (){
        return customerService.getCustomers();
    }

    @PostMapping
    public CustomerEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

    @PostMapping("/add-all")
    public List<CustomerEntity> addCustomers(@RequestBody List<CustomerRequest> customerRequest){
        return customerService.addCustomers(customerRequest);
    }

}
