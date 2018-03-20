package romajs.demo.javalogmdc.service;

public interface DemoService {
    void before(int entry);
    void doing(int entry);
    void after(int entry);
}
