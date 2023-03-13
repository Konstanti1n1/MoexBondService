package com.example.moexbondservice.controller;

import com.example.moexbondservice.DTO.StocksDTO;
import com.example.moexbondservice.DTO.TickersDTO;
import com.example.moexbondservice.service.MoexBondService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bonds")
@AllArgsConstructor
public class MoexBondController {

    private final MoexBondService bondService;

    @PostMapping("/getRequestedBonds")
    @ApiResponse(description = "получение облиаций")
    public StocksDTO getBondsFromMoex(@RequestBody TickersDTO tickers){

        return bondService.getBondsFromMoex(tickers);
    }
}
