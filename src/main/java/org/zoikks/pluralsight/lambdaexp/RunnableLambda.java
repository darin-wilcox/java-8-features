package org.zoikks.pluralsight.lambdaexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Class representing an example of using Lambda expressions with a Runnable interface...
 *
 */
public class RunnableLambda {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunnableLambda.class);

    public static void main(String... args) throws InterruptedException {

        // Demonstration of the historic wasy of defining an anonymous inner class.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    LOGGER.debug("Hello world from thread [" + Thread.currentThread().getName() + "]");
                }
            }
        };

        // Demonstration of the new Lambda expression syntax.
        Runnable runnableLambda = () -> {
            for (int i = 0; i < 3; i++) {
                LOGGER.debug("Hello world from thread [" + Thread.currentThread().getName() + "]");
            }
        };

        Thread t = new Thread(runnableLambda);
        t.start();
        t.join();
    }
}