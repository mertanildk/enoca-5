package com.example.enoca5.transformer;

import com.example.enoca5.consts.Messages;
import com.example.enoca5.dto.CustomerDto;
import com.example.enoca5.dto.CustomerUpdateDto;
import com.example.enoca5.dto.OrderDto;
import com.example.enoca5.dto.OrderUpdateDto;
import com.example.enoca5.entities.Customer;
import com.example.enoca5.entities.Order;
import com.example.enoca5.repositories.CustomerRepository;
import com.example.enoca5.repositories.OrderRepository;
import com.example.enoca5.services.CustomerService;
import com.example.enoca5.services.serviceImp.CustomerServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service("dtoFromEntityTransformer")
public class DtoToEntity {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;


    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setAge(customerDto.getAge());
        return customer;
    }

    public Customer customerDtoToCustomer(CustomerUpdateDto customerDto) {
        Customer customer = getCustomerOrThrow(customerDto.getCustomerId());
        if (!Objects.equals(customerDto.getName(), customer.getName())) {
            customer.setName(customer.getName());
        }
        if (customerDto.getAge() != customer.getAge()) {
            customer.setAge(customer.getAge());
        }
        customer.setName(customerDto.getName());

        return customer;
    }


    public Order orderDtoToOrder(OrderDto orderDto) {
        Customer customer = getCustomerOrThrow(orderDto.getCustomerOid());
        Order order = new Order();
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setCustomer(customer);
        return order;
    }

    public Order orderDtoToOrder(OrderUpdateDto orderUpdateDto) {
        Order order = getOrderOrThrow(orderUpdateDto);
        if (!Objects.equals(orderUpdateDto.getTotalPrice(), order.getTotalPrice())) {
            order.setTotalPrice(orderUpdateDto.getTotalPrice());
        }
        if (!Objects.equals(orderUpdateDto.getCustomerId(), order.getCustomer().getOid())) {
            Customer customer = getCustomerOrThrow(orderUpdateDto.getCustomerId());
            order.setCustomer(customer);
        }
        return order;
    }

    private Order getOrderOrThrow(OrderUpdateDto orderUpdateDto) {
        return orderRepository.findById(orderUpdateDto.getOrderId())
                .orElseThrow(() -> new RuntimeException(Messages.ORDER_NOT_FOUND));
    }

    private Customer getCustomerOrThrow(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(Messages.CUSTOMER_NOT_FOUND));
    }
}
