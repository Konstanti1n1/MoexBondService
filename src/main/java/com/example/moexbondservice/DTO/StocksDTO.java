package com.example.moexbondservice.DTO;

import com.example.moexbondservice.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StocksDTO {
    private List<Stock> stocks;
}
