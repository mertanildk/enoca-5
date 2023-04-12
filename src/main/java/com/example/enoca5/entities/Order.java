package com.example.enoca5.entities;

import com.example.enoca5.core.baseEntity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.time.LocalDate;


@Table(name = "Orders")
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_active = true")
public class Order extends BaseEntity {
    @Column(name = "create_date")
    private LocalDate createDate = LocalDate.now();
    @Column(name = "total_price")
    private Double totalPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_oid")
    private Customer customer;
}
