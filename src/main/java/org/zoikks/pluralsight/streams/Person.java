package org.zoikks.pluralsight.streams;

/**
 *
 * Basic POJO used in conjunction with the CollectorsExample.java
 *
 */
public class Person {

    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person [" + this.name + ", " + this.age + "]";
    }
}