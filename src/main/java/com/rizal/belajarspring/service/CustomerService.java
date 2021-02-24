package com.rizal.belajarspring.service;

import com.rizal.belajarspring.entity.CustomerEntity;
import com.rizal.belajarspring.model.CustomerRequest;

import java.util.List;

public interface CustomerService {

    List<CustomerEntity> getCustomers ();

    CustomerEntity addCustomer(CustomerRequest customerRequest);

    List<CustomerEntity> addCustomers(List<CustomerRequest> customerRequest);

    CustomerEntity editCustomer(Long customerId, CustomerRequest customerRequest);

    Integer deleteCustomer(Long customerId);

}
