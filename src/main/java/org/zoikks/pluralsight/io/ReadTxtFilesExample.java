package org.zoikks.pluralsight.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadTxtFilesExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadTxtFilesExample.class);

    public static void main(String... args) {

        ReadTxtFilesExample rtfe = new ReadTxtFilesExample();
        rtfe.tryWithResourcesJava7();
        rtfe.tryWithResourcesAndPath();
    }

    /**
     *
     * Example of a try-with-resources from Java 7 on how to read a txt file.
     *
     */
    private void tryWithResourcesJava7() {

        File file = new File((this.getClass().getClassLoader().getResource("people.txt")).getFile());

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file));) {

            Stream<String> stream = reader.lines();
            stream.filter(line -> line.contains("Sarah"))
                    .findFirst()
                    .ifPresent(LOGGER::debug);
        } catch (IOException e) {
            LOGGER.error("Unable to read the file.", e);
        }
    }

    private void tryWithResourcesAndPath() {

        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource("people.txt").toURI());

            // NOTE: Stream implements AutoCloseable, and will close the underlying file.
            try (Stream<String> stream = Files.lines(path)) {
                stream.filter(line -> line.contains("Sarah"))
                        .findFirst()
                        .ifPresent(LOGGER::debug);
            } catch (IOException ioe) {
                LOGGER.error("Unable to read the file.", ioe);
            }
        } catch (URISyntaxException e) {
            LOGGER.error("Unable to load path.", e);
        }
    }
}