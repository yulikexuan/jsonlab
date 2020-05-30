//: com.yulikexuan.jsonlab.model.BeerDtoTest.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("BeerDto JSON Processing Test - ")
class BeerDtoTest extends BaseTest {

    @Test
    void test_Given_BeerDto_Then_Serialize_To_JSON() throws Exception {

        // Given
        BeerDto beerDto = this.getBeerDto();

        // When
        String jsonBeer = this.objectMapper.writeValueAsString(beerDto);
        JSONObject jsonObj = new JSONObject(jsonBeer);
        String id = jsonObj.getString("beerId");
        String price = jsonObj.getString("price");

        // Then
        System.out.println(jsonBeer);
        assertThat(id).isEqualTo(this.id.toString());
        assertThat(price).isEqualTo(beerDto.getPrice().toString());
    }

    @Test
    void test_Given_Beer_JSON_String_Then_Deserialize_To_BeerDto() throws JsonProcessingException {

        // Given
        String jsonBeer = "{\"beerId\":\"fe85eda3-2688-4c8d-b85f-31f0c749090c\",\"beerName\":\"Heineken\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-05-30T08:31:19.068298-04:00\",\"lastUpdatedDate\":\"2020-05-30T08:31:19.068298-04:00\"}";

        // When
        BeerDto beerDto = this.objectMapper.readValue(jsonBeer, BeerDto.class);

        // Then
        System.out.println(beerDto);
    }

}///:~