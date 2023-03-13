package com.example.moexbondservice.parser;

import com.example.moexbondservice.DTO.BondDto;

import java.util.List;

public interface Parser {
    List<BondDto> parse(String ratesAsString);
}
