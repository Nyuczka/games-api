package com.sample.games_api.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonParser,
                                 DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        String date = jsonParser.getText();
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException exception) {
            return null;
        }
    }
}
