package com.example.moexbondservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Stock {

    String ticker;
    String figi;
    String name;
    String type;
    Currency currency;
    String source;
}
