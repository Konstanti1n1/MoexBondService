package com.example.moexbondservice.service;

import com.example.moexbondservice.DTO.BondDto;
import com.example.moexbondservice.DTO.FigiesDTO;
import com.example.moexbondservice.DTO.StocksDTO;
import com.example.moexbondservice.DTO.TickersDTO;
import com.example.moexbondservice.exception.BondsNotFoundException;
import com.example.moexbondservice.model.Currency;
import com.example.moexbondservice.model.Figi;
import com.example.moexbondservice.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MoexBondService implements MoexBondRepository {

    private final CacheBondRepository cacheBondRepository;
    @Override
    public StocksDTO getBondsFromMoex(TickersDTO tickers) {

        List<BondDto> resultBond = getAllContainsBond(tickers);

        if (resultBond.isEmpty()){
            log.error("Dont find out the bonds");
            throw new BondsNotFoundException("Не найдено запрашиваемых облигаций");
        }

        log.info("Convert and return bonds");
        return new StocksDTO(resultBond.stream().map(this::converToStocksDTO).toList());
    }

    @Override
    public FigiesDTO getPricesBonds(TickersDTO tickers) {

        List<BondDto> resultBond = getAllContainsBond(tickers);

        log.info("Convert and return bonds");
        List<Figi> prices = resultBond.stream().map(this::convertToFigi).toList();
        return new FigiesDTO(prices);
    }

    public List<BondDto> getAllContainsBond(TickersDTO tickers){
        log.info("Getting all bonds");
        List<BondDto> bondsAll = new ArrayList<>();
        bondsAll.addAll(cacheBondRepository.getCorpBonds());
        bondsAll.addAll(cacheBondRepository.getGovBonds());
        log.info("Received all bonds");

        log.info("Sorting all bonds");
        List<BondDto> resultBond = bondsAll.stream()
                .filter(bond->tickers.getTickers().contains(bond.getTicker()))
                .toList();
        log.info("Sorted all bonds");

        if (resultBond.isEmpty()){
            log.error("Dont find out the bonds");
            throw new BondsNotFoundException("Не найдено запрашиваемых облигаций");
        }

        return resultBond;
    }

    public Figi convertToFigi(BondDto bondDto){
        return Figi.builder()
                .price(bondDto.getPrice())
                .name(bondDto.getName())
                .build();
    }

    public Stock converToStocksDTO(BondDto bond){
        return Stock.builder()
                .name(bond.getName())
                .ticker(bond.getTicker())
                .figi(bond.getTicker())
                .source("MOEX")
                .currency(Currency.RUB)
                .type("Bond")
                .build();
    }
}
