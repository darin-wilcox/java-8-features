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

public class BuildingBiMap {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildingBiMap.class);

    public static void main(String... args) {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        BuildingBiMap.class.getClassLoader().getResourceAsStream("people-gender.txt")));

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

        Map<Integer, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getAge));

        map.forEach((age, personList) -> LOGGER.debug(age + " -> " + personList));

        // TODO Implement code that creates a Bimap.
    }
}
