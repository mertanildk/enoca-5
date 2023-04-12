package com.example.enoca5.services.serviceImp;

import com.example.enoca5.consts.Messages;
import com.example.enoca5.core.responseModel.RestResponseEntity;
import com.example.enoca5.dto.CustomerDto;
import com.example.enoca5.dto.CustomerUpdateDto;
import com.example.enoca5.entities.Customer;
import com.example.enoca5.repositories.CustomerRepository;
import com.example.enoca5.services.CustomerService;
import com.example.enoca5.specs.CustomerSpecification;
import com.example.enoca5.transformer.DtoToEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    private final DtoToEntity dtoToEntity;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer insert(CustomerDto customerDto) {
        Customer customer = dtoToEntity.customerDtoToCustomer(customerDto);
        return save(customer);
    }

    @Override
    public Customer update(CustomerUpdateDto customerDto) {
        Customer customer = dtoToEntity.customerDtoToCustomer(customerDto);
        return save(customer);
    }

    @Override
    public Customer delete(String customerId) {
        Customer customer = findById(customerId);
        customer.setIsActive(false);
        return customerRepository.save(customer);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        return customerRepository.findAll(Specification.allOf(new CustomerSpecification().search(name)));
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException(Messages.CUSTOMER_NOT_FOUND));
    }
    @Override
    public List<Customer> findAllCustomerWithoutOrder() {
        return customerRepository.findAllCustomerWithoutOrder();
    }


}