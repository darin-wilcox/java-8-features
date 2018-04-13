package org.zoikks.pluralsight.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WalkDirExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalkDirExample.class);

    public static void main(String... args) {

        WalkDirExample wde = new WalkDirExample();
    }

    private void walkPath() {

        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource(".").toURI());

            try (Stream<Path> stream = Files.walk(path, 2)) {
                stream.filter(myPath -> myPath.toFile().isDirectory())
                        .forEach(dir -> LOGGER.debug("Dir: " + dir));
            } catch (IOException ioe) {
                LOGGER.error("Unable to read path.", ioe);
            }
        } catch (URISyntaxException e) {
            LOGGER.error("Unable to load path.", e);
        }
    }
}