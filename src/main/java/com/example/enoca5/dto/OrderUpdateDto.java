package com.example.enoca5.dto;

import com.example.enoca5.core.baseDto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class OrderUpdateDto implements BaseDto, Serializable {

    @NotNull
    @NotEmpty
    private String orderId;
    private Double totalPrice;
    @NotBlank
    @NotNull
    private String customerId;
}
