package org.zoikks.pluralsight.datetime;

import java.time.LocalDate;

/**
 *
 * Basic POJO used in conjunction with DateAndTime.java
 *
 */
public class Person {

    private String name;
    private LocalDate dob;

    public Person() {

    }

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    @Override
    public String toString() {
        return "Person [" + this.name + ", " + this.dob + "]";
    }
}