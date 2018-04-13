package org.zoikks.pluralsight.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntermediaryAndFinal.class);

    public static void main(String... args) {

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        List<String> list = new ArrayList<>();

        stream
                .peek(LOGGER::debug)
                .filter(p1.or(p2))
                .forEach(list::add);

        LOGGER.debug("Done!");
        LOGGER.debug("size = " + list.size());
    }
}