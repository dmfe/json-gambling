package com.nc.jackson.annotations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserializer extends JsonDeserializer<Date> {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String date = parser.getText();
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}