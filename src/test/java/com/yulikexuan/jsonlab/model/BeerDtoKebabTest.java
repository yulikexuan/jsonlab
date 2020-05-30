//: com.yulikexuan.jsonlab.model.BeerDtoKebabTest.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("kebab")
@DisplayName("BeerDto JSON Processing Test With SNAKE CASE - ")
public class BeerDtoKebabTest extends BaseTest {

    @Test
    void test_Given_BeerDto_Then_Serialize_To_JSON() throws JsonProcessingException {

        // Given
        BeerDto beerDto = this.getBeerDto();

        // When
        String jsonBeer = this.objectMapper.writeValueAsString(beerDto);

        // Then
        System.out.println(jsonBeer);
    }

}///:~