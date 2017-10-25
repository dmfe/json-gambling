package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * @JsonAutoDetect is used to override the default semantic of witch properties are visible and which are not.
 * */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PrivateBean {
    private int id;
    private String name;

    public PrivateBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}