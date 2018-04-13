package org.zoikks.pluralsight.lambdaexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * Demonstrates the ability to chain Consumer instances together.
 *
 */
public class ChainConsumers {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChainConsumers.class);

    public static void main(String... args) {

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");

        List<String> result = new ArrayList<>();

        Consumer<String> c1 = s -> LOGGER.debug(s);
        Consumer<String> c2 = result::add;

        strings.forEach(c1.andThen(c2));
        LOGGER.debug("size of result = " + result.size());
    }
}