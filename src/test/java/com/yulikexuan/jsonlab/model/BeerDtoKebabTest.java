//: com.yulikexuan.jsonlab.model.BeerDtoKebabTest.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;


@JsonTest
@ActiveProfiles("kebab")
@DisplayName("BeerDto JSON Processing Test With SNAKE CASE - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BeerDtoKebabTest extends BaseTest {

    @Autowired
    private ObjectMapper objectMapper;

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