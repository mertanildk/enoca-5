package com.example.enoca5.services;

import com.example.enoca5.core.baseServices.BaseService;
import com.example.enoca5.dto.*;
import com.example.enoca5.entities.Customer;
import com.example.enoca5.entities.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService extends BaseService<Order, String> {
    List<Order> findAll();

    Order findById(String id);

    Order insert(OrderDto orderDto);

    Order update(OrderUpdateDto orderUpdateDto);

    Order delete(String orderId);

    Order save(Order order);

    List<Order> getOrdersByDate(LocalDate startDate);

    List<OrderSearchResponseDto> getOrdersByCustomerName(String name);
}
