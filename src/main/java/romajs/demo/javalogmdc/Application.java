package romajs.demo.javalogmdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import romajs.demo.javalogmdc.service.DemoService;
import romajs.demo.javalogmdc.service.DemoServiceImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("started");

        final ExecutorService executor = Executors.newFixedThreadPool(3);
        LOGGER.debug("submitting tasks");

        for (int i = 1; i <= 10; i++) {
            final DemoService demoService = new DemoServiceImpl();
            final Runnable task = new Log4JRunnable(demoService, i);
            executor.submit(task);
        }

        executor.shutdown();

        try {
            LOGGER.debug("awaiting termination");
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }

        LOGGER.info("finished");
    }
}
