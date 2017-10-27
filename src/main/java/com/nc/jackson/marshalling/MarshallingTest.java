package com.nc.jackson.marshalling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class MarshallingTest {
    private static final Logger log = Logger.getLogger(MarshallingTest.class);

    public void run() throws IOException {
        parsingJsonStringIntoJsonNode();
    }

    private void parsingJsonStringIntoJsonNode() throws IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObject = mapper.readTree(jsonString);
        log.info(actualObject.toString());
    }
}