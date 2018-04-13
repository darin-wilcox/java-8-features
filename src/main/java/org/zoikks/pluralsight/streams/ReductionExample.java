package org.zoikks.pluralsight.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReductionExample.class);

    public static void main(String... args) {

        List<Integer> list = Arrays.asList(-10);

        // Reduction using explicit Lambda function.
//        Integer reduction = list.stream().reduce(0, (i1, i2) -> i1 + i2);

        // Reduction using method reference.
//        Integer reduction = list.stream().reduce(0, Integer::sum);

        // Sum is the sum of the list plus the identity element
//        Integer reduction = list.stream().reduce(100, Integer::sum);

        // Max computes the max of the list AND the identity as well.
//        Integer reduction = list.stream().reduce(0, Integer::max);

//        LOGGER.debug(reduction.toString());

        // Example using Optional and no default value.
        Optional<Integer> reduction = list.stream().reduce(Integer::max);

        LOGGER.debug(reduction.get().toString());
    }
}