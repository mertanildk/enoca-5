package com.example.enoca5.dto;


import com.example.enoca5.core.baseDto.BaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements BaseDto, Serializable {
    @JsonProperty(value = "totalPrice")
    private Double totalPrice;
    @JsonProperty(value = "customer_oid")
    private String customerOid;
}
