//: com.yulikexuan.jsonlab.model.LocalDateSerializer.java


package com.yulikexuan.jsonlab.model;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator,
                          SerializerProvider serializers) throws IOException {

        jsonGenerator.writeObject(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
    }

}///:~