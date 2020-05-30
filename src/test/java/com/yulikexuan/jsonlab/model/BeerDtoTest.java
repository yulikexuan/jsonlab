//: com.yulikexuan.jsonlab.model.BeerDtoTest.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;


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
@DisplayName("BeerDto JSON Processing Test - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BeerDtoTest extends BaseTest {

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void test_Given_BeerDto_Then_Serialize_To_JSON() throws JsonProcessingException {

        // Given
        BeerDto beerDto = this.getBeerDto();

        // When
        String jsonBeer = this.objectMapper.writeValueAsString(beerDto);

        // Then
        System.out.println(jsonBeer);

    }

    @Test
    void test_Given_Beer_JSON_String_Then_Deserialize_To_BeerDto() throws JsonProcessingException {

        // Given
        String jsonBeer = "{\"id\":\"fe85eda3-2688-4c8d-b85f-31f0c749090c\",\"beerName\":\"Heineken\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-05-30T08:31:19.068298-04:00\",\"lastUpdatedDate\":\"2020-05-30T08:31:19.068298-04:00\"}";

        // When
        BeerDto beerDto = this.objectMapper.readValue(jsonBeer, BeerDto.class);

        // Then
        System.out.println(beerDto);
    }

}///:~