package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @JsonIgnoreProperties - one of the most common annotations in Jackson - is used to mark a property or
 * a list of properties to be ignored at the class level.
 * */
@JsonIgnoreProperties({"id"})
public class BeanWithIgnore {
    public int id;
    public String name;
    /**
     * @JsonIgnore annotation is used to mark a property to be ignored at the field level.
     * */
    @JsonIgnore
    public boolean state;

    public BeanWithIgnore(int id, String name, boolean state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }
}