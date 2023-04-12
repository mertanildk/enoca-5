package com.example.enoca5.dto;


import com.example.enoca5.core.baseDto.BaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDto implements BaseDto, Serializable {
    @JsonProperty(value = "customerId")
    private String customerId;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "age")
    private Integer age;
}
