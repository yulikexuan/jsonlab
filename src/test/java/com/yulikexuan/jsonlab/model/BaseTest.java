//: com.yulikexuan.jsonlab.model.BaseTest.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;


/*
 * Annotation for a JSON test that focuses only on JSON serialization.
 * Using this annotation will disable full auto-configuration and instead apply
 * only configuration relevant to JSON tests (i.e. @JsonComponent, Jackson Module)
 *
 * By default, tests annotated with JsonTest will also initialize JacksonTester,
 * JsonbTester and GsonTester fields. More fine-grained control can be provided
 * via the @AutoConfigureJsonTesters annotation.
 */
@JsonTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    UUID id;
    BigDecimal price = BigDecimal.valueOf(12.99);

    @BeforeEach
    void setUp() {
        this.id = UUID.randomUUID();
    }

    BeerDto getBeerDto() {
        return  BeerDto.builder()
                .beerName("Heineken")
                .beerStyle("Ale")
                .id(this.id)
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(price)
                .upc(123123123123L)
                .myLocalDate(LocalDate.now())
                .build();
    }

}///:~