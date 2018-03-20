package romajs.demo.javalogmdc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    public void before(int entry) {
        LOGGER.trace("before: " + entry);
    }

    public void doing(int entry) {
        LOGGER.trace("doing: " + entry);
    }

    public void after(int entry) {
        LOGGER.trace("after: " + entry);
    }
}
