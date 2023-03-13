package com.example.moexbondservice.DTO;

import lombok.Data;

@Data
public class ErrorDTO {
    private String error;
    public ErrorDTO(String error) {
        this.error = error;
    }
}
