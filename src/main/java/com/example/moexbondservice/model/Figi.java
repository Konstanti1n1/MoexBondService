package com.example.moexbondservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Figi {
    private Double price;
    private String name;
}
