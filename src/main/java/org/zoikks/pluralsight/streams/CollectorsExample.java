package org.zoikks.pluralsight.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectorsExample.class);

    public static void main(String... args) {

        List<Person> persons = new ArrayList<>();

        // Example of try-with-resources...
        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        CollectorsExample.class.getClassLoader().getResourceAsStream("people.txt")));

                Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p.toString();
            }).forEach(LOGGER::debug);
        } catch (IOException e) {
            LOGGER.error("Failure reading file.", e);
        }


        // Example of a Reduction using a Comparator
        Optional<Person> opt =
        persons.stream().filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));

        LOGGER.debug(opt.toString());

        // Another example of a Reduction using a Comparator...
        Optional<Person> opt2 =
                persons.stream().max(Comparator.comparing(Person::getAge));

        LOGGER.debug(opt2.toString());

        // Example of a Collector...
        Map<Integer, List<Person>> map = persons.stream().collect(
                Collectors.groupingBy(Person::getAge)
        );

        LOGGER.debug(map.toString());

        // Another example of a Collector with some complications...
        Map<Integer, Set<String>> map2 = persons.stream().collect(
                Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(
                                Person::getName,
                                Collectors.toCollection(TreeSet::new)
                        )
                )
        );

        LOGGER.debug(map2.toString());
    }
}