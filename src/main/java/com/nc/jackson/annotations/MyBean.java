package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @JsonPropertyOrder annotation is used to specify the order of properties on serialization
 * @JsonInclude is used to exclude properties with empty/null/default values.
 * */
@JsonPropertyOrder({"name","id"})
@JsonInclude(Include.NON_NULL)
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