package org.zoikks.pluralsight.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlatMapExample.class);

    public static void main(String... args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> list3 = Arrays.asList(3, 5, 7);

        List<List<Integer>> list = Arrays.asList(list1, list2, list3);

        LOGGER.debug("List of lists: " + list);

//  Dealing with Lists of lists first...
        list.stream()
                .map(List::size)
                .forEach(System.out::println);

        Function<List<?>, Integer> size = List::size;
        Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();

// Outputs the memory reference (ie java.util.stream.ReferencePipeline$Head@4fb64261)
        list.stream()
                .map(flatMapper)
                .forEach(System.out::println);

// Use of flatMap, flattens the contents of the lists into individual elements.
        list.stream()
                .flatMap(flatMapper)
                .forEach(System.out::println);
    }
}
