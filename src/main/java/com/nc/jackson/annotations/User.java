package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class User {
    public int id;
    public Name name;

    public User(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @JsonIgnoreType is used to marl all properties of annotated type to be ignored.
     * */
    @JsonIgnoreType
    public static class Name {
        public String firstName;
        public String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}