package com.example.enoca5.controllers;


import com.example.enoca5.core.responseModel.RestResponseEntity;
import com.example.enoca5.dto.CustomerDto;
import com.example.enoca5.dto.OrderDto;
import com.example.enoca5.dto.OrderSearchResponseDto;
import com.example.enoca5.dto.OrderUpdateDto;
import com.example.enoca5.entities.Customer;
import com.example.enoca5.entities.Order;
import com.example.enoca5.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/Orders")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<List<Order>>> getAllOrders() {
        return ResponseEntity.ok(RestResponseEntity.response(orderService.findAll()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Order>> getOrder(@PathVariable("id") String orderId) {
        return ResponseEntity.ok(RestResponseEntity.response(orderService.findById(orderId)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Order>> addOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(RestResponseEntity.response(orderService.insert(orderDto)));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Order>> updateOrder(@RequestBody OrderUpdateDto orderDto) {
        return ResponseEntity.ok(RestResponseEntity.response(orderService.update(orderDto)));
    }

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Order>> deleteOrder(@PathVariable("id") String id) {
        return ResponseEntity.ok(RestResponseEntity.response(orderService.delete(id)));
    }

    @GetMapping(value = "/getOrdersByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<List<Order>>> getOrdersByDate(@RequestParam("startDate") LocalDate startDate) {
        return ResponseEntity.ok(RestResponseEntity.response(orderService.getOrdersByDate(startDate)));
    }

    @GetMapping(value = "/getOrdersByCustomerName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<List<OrderSearchResponseDto>>> getOrdersByCustomerName(@RequestParam("name") String name) {
        return ResponseEntity.ok(RestResponseEntity.response(orderService.getOrdersByCustomerName(name)));
    }
}
