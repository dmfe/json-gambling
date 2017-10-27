package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

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

    public MyBean() {}

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

    /**
     * @JsonSetter is an alternative to @JsonProperty - used to mark a method as a setter method.
     * This is super useful when we need to read some JSON data, but the target entity class doesn't
     * exactly match that data and so we need to tune the process to make it fit.
     * */
    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }
}