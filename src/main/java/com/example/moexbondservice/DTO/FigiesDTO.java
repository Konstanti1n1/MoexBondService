package com.example.moexbondservice.DTO;

import com.example.moexbondservice.model.Figi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class FigiesDTO {
    private List<Figi> figi;
}
