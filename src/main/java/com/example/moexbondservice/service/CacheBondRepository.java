package com.example.moexbondservice.service;

import com.example.moexbondservice.DTO.BondDto;

import java.util.List;

public interface CacheBondRepository {

    List<BondDto> getGovBonds ();
     List<BondDto> getCorpBonds ();

}
