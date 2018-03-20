package romajs.demo.javalogmdc;

import org.slf4j.MDC;
import romajs.demo.javalogmdc.service.DemoService;

public class Log4JRunnable implements Runnable {
    private DemoService demoService;
    private int entry;

    public Log4JRunnable(DemoService demoService, int entry) {
        this.demoService = demoService;
        this.entry = entry;
    }

    public void run() {
        MDC.put("entry", String.valueOf(entry));
        try {
            demoService.before(entry);
            Thread.sleep(100);
            demoService.doing(entry);
            Thread.sleep(100);
            demoService.after(entry);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MDC.clear();
    }
}
