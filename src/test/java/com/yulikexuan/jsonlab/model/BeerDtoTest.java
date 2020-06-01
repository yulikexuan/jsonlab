//: com.yulikexuan.jsonlab.model.BeerDtoTest.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
        String localDate = jsonObj.getString("myLocalDate");

        // Then
        System.out.println(jsonBeer);
        assertThat(id).isEqualTo(this.id.toString());
        assertThat(price).isEqualTo(beerDto.getPrice().toString());
        assertThat(localDate).doesNotContain("-");
    }

    @Test
    void test_Given_Beer_JSON_String_Then_Deserialize_To_BeerDto() throws JsonProcessingException {

        // Given
        String jsonBeer = "{\"beerName\":\"Heineken\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2020-06-01T08:39:38-0400\",\"lastUpdatedDate\":\"2020-06-01T08:39:38.7310088-04:00\",\"myLocalDate\":\"20200601\",\"beerId\":\"c73c319a-4304-4d16-ab39-2193719c3aaf\"}";

        // When
        BeerDto beerDto = this.objectMapper.readValue(jsonBeer, BeerDto.class);
        LocalDate localDate = beerDto.getMyLocalDate();

        // Then
        System.out.println(beerDto);
        assertThat(localDate).isNotNull();
    }

}///:~