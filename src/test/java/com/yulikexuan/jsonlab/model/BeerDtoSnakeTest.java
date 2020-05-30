//: com.yulikexuan.jsonlab.model.BeerDtoSnakeTest.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("snake")
@DisplayName("BeerDto JSON Processing Test With SNAKE CASE - ")
public class BeerDtoSnakeTest extends BaseTest {

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