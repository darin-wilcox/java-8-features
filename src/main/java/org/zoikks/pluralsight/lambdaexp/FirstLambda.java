package org.zoikks.pluralsight.lambdaexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * Class representing an example of using Lambda expressions with a FileFilter interface...
 *
 */
public class FirstLambda {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstLambda.class);

    public static void main(String... args) {

        // Demonstration of the historic way of defining anonymous inner classes.
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        // Demonstration of the new Lambda expression syntax.
        FileFilter filterLambda = (File pathname) ->
                pathname.getName().endsWith(".java");


        File dir = new File("./src/main/java/org/zoikks/pluralsight/lambdaexp/");

        File[] files = dir.listFiles(filterLambda);

        for (File f : files) {
            LOGGER.debug("File: " + f);
        }
    }
}