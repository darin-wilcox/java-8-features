package org.zoikks.pluralsight.datetime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateAndTime {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateAndTime.class);

    public static void main(String... args) {

        List<Person> persons = new ArrayList<>();

        // Example of try-with-resources...
        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        DateAndTime.class.getClassLoader().getResourceAsStream("people-dob.txt")));

                Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                String name = s[0].trim();
                int year = Integer.parseInt(s[1]);
                Month month = Month.of(Integer.parseInt(s[2]));
                int day = Integer.parseInt(s[3]);
                Person p = new Person(name, LocalDate.of(year, month, day));
                persons.add(p);
                return p.toString();
            }).forEach(LOGGER::debug);
        } catch (IOException e) {
            LOGGER.error("Failure reading file.", e);
        }

        LocalDate now = LocalDate.of(2014, Month.MARCH, 12);

        persons.stream().forEach(
                p -> {
                    Period period = Period.between(p.getDob(), now);
                    LOGGER.debug(p.getName() + " was born " + period.get(ChronoUnit.YEARS) + " years");
                }
        );
    }
}