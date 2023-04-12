package com.example.enoca5.services.serviceImp;

import com.example.enoca5.consts.Messages;
import com.example.enoca5.dto.OrderDto;
import com.example.enoca5.dto.OrderSearchResponseDto;
import com.example.enoca5.dto.OrderUpdateDto;
import com.example.enoca5.entities.Customer;
import com.example.enoca5.entities.Order;
import com.example.enoca5.repositories.OrderRepository;
import com.example.enoca5.services.CustomerService;
import com.example.enoca5.services.OrderService;
import com.example.enoca5.specs.CustomerSpecification;
import com.example.enoca5.transformer.DtoToEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final DtoToEntity dtoToEntity;
    private final CustomerService customerService;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }


    @Override
    public Order insert(OrderDto orderDto) {
        Order order = dtoToEntity.orderDtoToOrder(orderDto);
        save(order);
        return order;
    }

    @Override
    public Order update(OrderUpdateDto orderUpdateDto) {
        Order order = dtoToEntity.orderDtoToOrder(orderUpdateDto);
        return save(order);
    }

    @Override
    public Order delete(String orderId) {
        Order order = findById(orderId);
        order.setIsActive(false);
        return save(order);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate startDate) {
        return orderRepository.findAllByOrderDateGreaterThanEqual(startDate);
    }

    @Override
    public Order findById(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException(Messages.ORDER_NOT_FOUND));
    }

    @Override
    public List<OrderSearchResponseDto> getOrdersByCustomerName(String name) {
        List<Customer> customers = customerService.getCustomerByName(name);
        List<Order> orders = orderRepository.findAllByCustomers(customers);
        return setOrderSearchDtoFromOrders(orders);
    }




    private static List<OrderSearchResponseDto> setOrderSearchDtoFromOrders(List<Order> orders) {
        return orders.stream().map(order -> {
            OrderSearchResponseDto orderSearchResponseDto = new OrderSearchResponseDto();
            orderSearchResponseDto.setOrderId(order.getOid());
            orderSearchResponseDto.setCustomerId(order.getCustomer().getOid());
            return orderSearchResponseDto;
        }).toList();
    }

}
