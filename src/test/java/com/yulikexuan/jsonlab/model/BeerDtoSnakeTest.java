//: com.yulikexuan.jsonlab.model.BeerDtoSnakeTest.java


package com.yulikexuan.jsonlab.model;


import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("snake")
@DisplayName("BeerDto JSON Processing Test With SNAKE CASE - ")
public class BeerDtoSnakeTest extends BaseTest {

    @Test
    void test_Given_BeerDto_Then_Serialize_To_JSON() throws Exception {

        // Given
        BeerDto beerDto = this.getBeerDto();

        // When
        String jsonBeer = this.objectMapper.writeValueAsString(beerDto);
        JSONObject jsonObject = new JSONObject(jsonBeer);
        String actualId = jsonObject.getString("beerId");

        // Then
        System.out.println(jsonBeer);
        assertThat(actualId).isEqualTo(this.id.toString());
    }

}///:~