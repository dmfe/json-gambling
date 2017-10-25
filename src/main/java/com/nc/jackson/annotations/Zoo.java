package com.nc.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class Zoo {
    public List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * @JsonTypeInfo is used to indicate details of what type of information is included in serialization.
     * @JsonSubTypes is used to indicate sub-types of annotated type.
     * @JsonTypeName is used to define logical type name to use for annotated class.
     * */

    @JsonTypeInfo(use=Id.NAME,
            include = As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @Type(value=Dog.class, name="dog"),
            @Type(value=Cat.class, name="cat")
    })
    public static class Animal {
        public String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        public boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}