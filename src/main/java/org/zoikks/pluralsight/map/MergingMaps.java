package org.zoikks.pluralsight.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergingMaps.class);

    public static void main(String... args) {

        MergingMaps mapExample = new MergingMaps();
    }

    MergingMaps() {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        MergingMaps.class.getClassLoader().getResourceAsStream("people-gender.txt")));

                Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
                persons.add(p);
                return p.toString();
            }).forEach(LOGGER::debug);
        } catch (IOException e) {
            LOGGER.error("Failure reading file.", e);
        }

        persons.forEach(person -> LOGGER.debug(person.toString()));

        List<Person> list1 = persons.subList(1, 10);
        List<Person> list2 = persons.subList(10, persons.size());

        Map<Integer, List<Person>> map1 = this.mapByAge(list1);
        LOGGER.debug("Map 1: ");
        map1.forEach((age, personList) -> LOGGER.debug(age + " " + personList));

        LOGGER.debug("Map 2: ");
        Map<Integer, List<Person>> map2 = this.mapByAge(list2);
        map2.forEach((age, personList) -> LOGGER.debug(age + " " + personList));


        // Example of merging:
        map2.entrySet().stream().forEach(
                entry ->
                        map1.merge( // This is the target of the merge...
                                entry.getKey(),
                                entry.getValue(),
                                (l1, l2) -> {
                                    l1.addAll(l2);
                                    // Merge expects a return type matching the merge type.
                                    return l1;
                                }
                        )
        );

        LOGGER.debug("Map 1 Merged: ");
        map1.forEach((age, personList) -> {
            LOGGER.debug(age + " " + personList);
        });
    }

    private Map<Integer, List<Person>> mapByAge(List<Person> list) {

        Map<Integer, List<Person>> map =
                list.stream().collect(
                        Collectors.groupingBy(Person::getAge)
                );

        return map;
    }
}