package org.zoikks.pluralsight.map;

/**
 *
 * Basic POJO used in conjunction with the MergingMaps.java
 *
 */
public class Person {

    private String name;
    private int age;
    private String gender;

    public Person() {

    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return "Person [" + this.name + ", " + this.age + ", " + this.gender + "]";
    }
}