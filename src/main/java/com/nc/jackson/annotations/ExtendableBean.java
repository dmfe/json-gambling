package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    @JsonCreator
    public ExtendableBean(@JsonProperty("name") String name) {
        this.name = name;
        properties = new HashMap<>();
    }

    /**
     * @JsonAnyGetter annotation allows the flexibility od using a Map filed as standard properties.
     * */
    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    /**
     * @JsonAnySetter allows you the flexibility of using a Map as a standard properties.
     * */
    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }
}