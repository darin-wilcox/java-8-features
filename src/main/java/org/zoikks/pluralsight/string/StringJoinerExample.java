package org.zoikks.pluralsight.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;

public class StringJoinerExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringJoinerExample.class);

    public static void main(String... args) {

        String stringA = "George";
        String stringB = "Tucker";

        // String concat using '+' operator
        String concatPlus = stringA + " " + stringB;
        LOGGER.debug("Using '+': " + concatPlus);

        // String concat using 'StringBuffer'
        // NOTE: StringBuffer is synchronized.  Regardless, the compiler optimizes it if synchronization is not required
        StringBuffer sbuffer = new StringBuffer(stringA);
        sbuffer.append(" ").append(stringB);
        LOGGER.debug("Using 'StringBuffer':" + sbuffer.toString());

        // String concat using 'StringBuilder' (new from Java 5)
        StringBuilder sbuilder = new StringBuilder(stringA);
        sbuilder.append(" ").append(stringB);
        LOGGER.debug("Using 'StringBuilder': " + sbuilder.toString());

        // String concat using 'StringJoiner'
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(stringA).add(stringB);
        LOGGER.debug("Using 'StringJoiner': " + stringJoiner);


        // Even better with the StringJoiner:
        String[] tab = {"one", "two", "three"};
        String s = String.join(", ", tab);
        LOGGER.debug("Awesome tidbit from StringJoiner: " + s);
    }
}