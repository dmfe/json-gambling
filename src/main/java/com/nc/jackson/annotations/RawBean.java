package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawBean {
    public String name;

    /**
     * @JsonRawValue is used to instruct Jackson to serialize a property exactly as is.
     * */
    @JsonRawValue
    public String json;

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }
}