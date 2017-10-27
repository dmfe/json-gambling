package com.nc.jackson.annotations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Event {
    public String name;

    /**
     * @JsonSerialize is used to indicate a custom serializer will be used to marshal the entity.
     * @JsonDeserialize is used to indicate the use of custom deserializer.
     * */
    @JsonSerialize(using=CustomDateSerializer.class)
    @JsonDeserialize(using=CustomDateDeserializer.class)
    public Date eventDate;

    public Event() {}

    public Event(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }
}