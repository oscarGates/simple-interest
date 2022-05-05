package com.simple.interest.simpleinterest.dtos;

import lombok.Builder;

@lombok.Data
@Builder
public class Data {
    private Double amount;
    private Integer terms;
    private Double rate;
}
