package com.example.moexbondservice.service;

import com.example.moexbondservice.DTO.FigiesDTO;
import com.example.moexbondservice.DTO.StocksDTO;
import com.example.moexbondservice.DTO.TickersDTO;

public interface MoexBondRepository {

    StocksDTO getBondsFromMoex(TickersDTO tickers);

    FigiesDTO getPricesBonds(TickersDTO tickersDTO);


}
