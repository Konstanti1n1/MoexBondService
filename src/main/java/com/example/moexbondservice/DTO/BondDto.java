package com.example.moexbondservice.DTO;

import lombok.Value;

@Value
public class BondDto {
    String ticker;
    Double price;
    String name;
}
