package com.example.moexbondservice.service;

import com.example.moexbondservice.DTO.BondDto;
import com.example.moexbondservice.exception.LimitedRequestForMoex;
import com.example.moexbondservice.moexClient.CorporateBondsClient;
import com.example.moexbondservice.moexClient.GovBondsClient;
import com.example.moexbondservice.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CacheBondsService implements CacheBondRepository{

    private final Parser parser;
    private final CorporateBondsClient corporateBondsClient;
    private final GovBondsClient govBondsClient;

    @Cacheable("gov")
    @Override
    public List<BondDto> getGovBonds (){
        log.info("Getting government bonds ");
        String govBonds = govBondsClient.getBondsFromMoex();
        List<BondDto> bonds =  parser.parse(govBonds);

        if(bonds.isEmpty()) {
            log.error("Moex dont answer on request government bonds");
            throw new LimitedRequestForMoex("Превышен лимит запросов по государственным облигациям ");
        }
        log.info("Received government bonds");
        return bonds;
    }

    @Cacheable("corp")
    @Override
    public List<BondDto> getCorpBonds (){
        log.info("Getting corporate bonds ");

        String corpBonds =corporateBondsClient.getBondsFromMoex();
        List<BondDto> bonds = parser.parse(corpBonds);

        if(bonds.isEmpty()) {
            log.error("Moex dont answer on request corporate bonds");
            throw new LimitedRequestForMoex("Превышен лимит запросов по корпоротивным облиациям ");
        }
        log.info("Received corporate bonds");
        return bonds;
    }
}
