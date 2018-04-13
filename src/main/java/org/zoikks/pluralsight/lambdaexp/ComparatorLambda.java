package org.zoikks.pluralsight.lambdaexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComparatorLambda.class);

    public static void main(String... args) {

        // Demonstration of the historic wasy of defining an anonymous inner class.
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        // Demonstration of the new Lambda expression syntax.
        Comparator<String> comparatorLambda = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };

        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, comparatorLambda);

        // A little demonstration of Streams :)
        list.forEach(System.out::println);
    }
}