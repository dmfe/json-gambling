package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {
    TYPE1(1, "Type_1"),
    TYPE2(2, "Type_2");

    private Integer id;
    private String name;

    private TypeEnumWithValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @JsonValue indicates a single method that should be used to serialized the entire instance.
     * */
    @JsonValue
    public String getName() {
        return name;
    }
}