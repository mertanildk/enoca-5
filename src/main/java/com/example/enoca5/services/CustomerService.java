package com.example.enoca5.services;

import com.example.enoca5.dto.CustomerDto;
import com.example.enoca5.dto.CustomerUpdateDto;
import com.example.enoca5.entities.Customer;
import com.example.enoca5.core.baseServices.BaseService;

import java.util.List;

public interface CustomerService extends BaseService<Customer, String> {
    List<Customer> findAll();
    Customer findById(String id);

    Customer insert(CustomerDto customerDto);

    Customer update(CustomerUpdateDto customerDto);

    Customer delete(String customerId);

    Customer save(Customer customer);

    List<Customer> getCustomerByName(String name);
    List<Customer> findAllCustomerWithoutOrder();
}

