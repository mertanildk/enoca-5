package com.example.enoca5.repositories;

import com.example.enoca5.entities.Customer;
import com.example.enoca5.entities.Order;
import com.example.enoca5.core.baseRepository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order> {
    @Query("select o from Order o where o.createDate >= :startDate")
    List<Order> findAllByOrderDateGreaterThanEqual(LocalDate startDate);

    @Query("select o from Order o where o.customer in :customers")
    List<Order> findAllByCustomers(List<Customer> customers);
}
