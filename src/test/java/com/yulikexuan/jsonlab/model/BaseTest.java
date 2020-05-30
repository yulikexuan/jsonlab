//: com.yulikexuan.jsonlab.model.BaseTest.java


package com.yulikexuan.jsonlab.model;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


public class BaseTest {

    BeerDto getBeerDto() {
        return  BeerDto.builder()
                .beerName("Heineken")
                .beerStyle("Ale")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(123123123123L)
                .build();
    }

}///:~