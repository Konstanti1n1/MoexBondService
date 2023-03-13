package com.example.moexbondservice.exception;

import com.example.moexbondservice.DTO.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseError extends ResponseEntity<ErrorDTO> {
    public ResponseError(ErrorDTO body, HttpStatusCode status) {
        super(body, status);
    }
}
