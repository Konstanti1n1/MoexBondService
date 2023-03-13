package com.example.moexbondservice.exception;

import com.example.moexbondservice.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseError handleExceptionFromLimited(LimitedRequestForMoex ex){
        return new ResponseError(new ErrorDTO(ex.getMessage()), HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    @ExceptionHandler
    public ResponseError handleExceptionNotFondBonds(BondsNotFoundException ex){
        return new ResponseError(new ErrorDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseError handleExceptionFromPriceService(BondParsingException ex){
        return new ResponseError(new ErrorDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}

