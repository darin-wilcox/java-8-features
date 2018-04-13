package org.zoikks.pluralsight.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceAggregatesExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReduceAggregatesExample.class);

    public static void main(String... args) {

        int nonZeroSum = summation(Arrays.asList(1,3,5,7,9).stream());
        LOGGER.debug("Non-Zero Sum: " + nonZeroSum);

        int defaultSum = summation(Stream.empty());
        LOGGER.debug("Default Sum: " + defaultSum);

        int oneSum = summation(Stream.of(1));
        LOGGER.debug("One Element Sum: " + oneSum);
    }

    private static Integer summation(Stream<Integer> stream) {

        Integer id = 0;
        BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;

        return stream.reduce(id, sum);
    }
}