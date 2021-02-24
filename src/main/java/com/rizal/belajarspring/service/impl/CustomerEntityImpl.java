package com.rizal.belajarspring.service.impl;

import com.rizal.belajarspring.entity.CustomerEntity;
import com.rizal.belajarspring.model.CustomerRequest;
import com.rizal.belajarspring.repository.CustomerEntityRepository;
import com.rizal.belajarspring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerEntityImpl implements CustomerService {

    @Autowired
    private CustomerEntityRepository customerEntityRepository;

    @Override
    public List<CustomerEntity> getCustomers() {
        return customerEntityRepository.findAll();
    }

    @Override
    public  List<CustomerEntity> addCustomers(List<CustomerRequest> customerRequest) {

        // 01. Create list of customer
        List<CustomerEntity> customerEntityList = new ArrayList<>();

        // 02. Looping CustomerRequest data
        for (CustomerRequest customer : customerRequest){

            // 03. Mapping CustomerRequest to CustomerEntity
            CustomerEntity cS = new CustomerEntity(
                    customer.getEmail(),
                    customer.getUserName(),
                    customer.getCardNumber(),
                    customer.getHandPhone()
            );

            // 04. Add CustomerEntity to customerEntityList
            customerEntityList.add(cS);
        }

        // 05. Save All to DB
        return customerEntityRepository.saveAll(customerEntityList);
    }

    @Override
    public CustomerEntity addCustomer(CustomerRequest customerRequest) {

        CustomerEntity customerToSave = new CustomerEntity(
                customerRequest.getEmail(),
                customerRequest.getUserName(),
                customerRequest.getCardNumber(),
                customerRequest.getHandPhone()
        );
        return customerEntityRepository.save(customerToSave);
    }

    @Override
    public CustomerEntity editCustomer(Long customerId, CustomerRequest customerRequest) {
        return null;
    }

    @Override
    public Integer deleteCustomer(Long customerId) {
        return null;
    }
}
