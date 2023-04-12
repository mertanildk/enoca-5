package com.example.enoca5.repositories;

import com.example.enoca5.core.baseRepository.BaseRepository;
import com.example.enoca5.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends BaseRepository<Customer> {

    @Query(value = "SELECT c.* FROM customers c LEFT JOIN orders o ON c.\"oid\"  = o.customer_oid WHERE o.\"oid\"  IS NULL;",
            nativeQuery = true)
    List<Customer> findAllCustomerWithoutOrder();
}
