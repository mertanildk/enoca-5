package com.example.enoca5.entities;

import com.example.enoca5.core.baseEntity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;
import java.util.Set;

@Table(name = "Customers")
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_active = true")
public class Customer extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
}
