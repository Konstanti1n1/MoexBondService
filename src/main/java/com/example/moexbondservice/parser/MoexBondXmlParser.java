package com.example.moexbondservice.parser;

import com.example.moexbondservice.DTO.BondDto;
import com.example.moexbondservice.exception.BondParsingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MoexBondXmlParser implements Parser {

    @Override
    public List<BondDto> parse(String ratesAsString) {

        StringBuilder builder = new StringBuilder();
        String[] splitByRow = ratesAsString.split("row");

        ArrayList<String[]> splitBySpace = new ArrayList<>();

        for (int i = 1; i < splitByRow.length; i++) {
            splitBySpace.add(splitByRow[i].split("="));
        }


       return parseStringToBondList(splitBySpace, ratesAsString);
    }





    public List<BondDto> parseStringToBondList(ArrayList<String[]> splitBySpace,String ratesAsString){
            Random random = new Random();
            ArrayList<BondDto> bonds = new ArrayList<BondDto>();

            try {
                for (int i = 1; i < splitBySpace.size() - 1; i++) {

                    StringBuilder ticker = new StringBuilder();
                    StringBuilder name = new StringBuilder();

                    String[] strings = splitBySpace.get(i);

                    String[] first = strings[1].split("");
                    List<String> resultFirst = Arrays.stream(first).skip(1).takeWhile(x -> !x.equals("\"")).toList();
                    for (int j = 0; j < resultFirst.size(); j++) {
                        ticker.append(resultFirst.get(j));
                    }

                    String[] third = strings[3].split("");
                    List<String> resultThird = Arrays.stream(third).skip(1).takeWhile(x -> !x.equals("\"")).toList();
                    for (int j = 0; j < resultThird.size(); j++) {
                        name.append(resultThird.get(j));
                    }

                    double digital = Math.round(random.nextDouble(1000));
                    bonds.add(new BondDto(ticker.toString(),digital,name.toString()));

                }
            }
            catch (Exception ex) {
                log.error("xml parsing error, xml:{}", ratesAsString, ex);
                throw new BondParsingException(ex);
            }
        System.out.println(bonds);
            return bonds;
        }
}
