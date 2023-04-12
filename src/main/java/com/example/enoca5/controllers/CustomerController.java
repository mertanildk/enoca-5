package com.example.enoca5.controllers;

import com.example.enoca5.core.responseModel.RestResponseEntity;
import com.example.enoca5.dto.CustomerDto;
import com.example.enoca5.dto.CustomerUpdateDto;
import com.example.enoca5.entities.Customer;
import com.example.enoca5.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<List<Customer>>> getAllCustomers() {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.findAll()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Customer>> getCustomer(@PathVariable("id") String id) {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.findById(id)));
    }

    @PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Customer>> addCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.insert(customerDto)));
    }

    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Customer>> updateCustomer(@RequestBody @Valid CustomerUpdateDto customerDto) {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.update(customerDto)));
    }

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<Customer>> deleteCustomer(@PathVariable("id") String id) {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.delete(id)));
    }
    @GetMapping(value = "/getCustomersWithoutOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponseEntity<List<Customer>>> getCustomersWithoutOrder() {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.findAllCustomerWithoutOrder()));
    }
}
