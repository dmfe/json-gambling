package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @JsonPropertyOrder annotation is used to specify the order of properties on serialization
 * */
@JsonPropertyOrder({"name","id"})
public class MyBean {
    public int id;
    private String name;

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @JsonGetter annotation is an alternative to @JsonProperty annotation to mark the specified
     * method as a getter method.
     * */
    @JsonGetter("name")
    public String getTheName() {
        return name;
    }
}