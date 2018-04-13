package org.zoikks.pluralsight.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * Example of Consuming and Filtering Streams.
 *
 */
public class FirstPredicates {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstPredicates.class);

    public static void main(String... args) {

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = s -> s.length() > 3;

        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        stream
                .filter(p2.or(p3))
                .forEach(s -> LOGGER.debug(s));
    }
}