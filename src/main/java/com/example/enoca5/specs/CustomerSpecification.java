package com.example.enoca5.specs;

import com.example.enoca5.entities.Customer;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {

    public Specification<Customer> search(String customerName) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!ObjectUtils.isEmpty(customerName)) {
                predicates.add
                        (criteriaBuilder.like(criteriaBuilder.lower(root.get("name")
                        ), "%" + customerName.toLowerCase() + "%"));

            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
