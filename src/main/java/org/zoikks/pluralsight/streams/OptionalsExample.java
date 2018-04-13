package org.zoikks.pluralsight.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OptionalsExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionalsExample.class);

    public static void main(String... args) {

        Person p1 = new Person("Han", "Solo", 99);
        Person p2 = new Person("Luke","Skywalker", 88);
        Person p3 = new Person("George", "Lucas", 77);

        List<Person> persons = Arrays.asList(p1, p2);

        Optional<Integer> minAge =
                persons.stream()
                    .map(person -> person.getAge())         // Stream<Integer>
                    .filter(age -> age > 20)                // Stream<Integer>
                    .min(Comparator.naturalOrder());        // terminal operation

        LOGGER.debug(minAge.toString());
    }

    private static class Person {

        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }
    }
}