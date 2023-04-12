package com.example.enoca5.dto;

import com.example.enoca5.core.baseDto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class OrderSearchResponseDto implements BaseDto, Serializable {
    String customerId;
    String orderId;
}
