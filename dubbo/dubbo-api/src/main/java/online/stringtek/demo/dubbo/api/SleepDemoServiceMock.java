package online.stringtek.demo.dubbo.api;

public class SleepDemoServiceMock implements SleepDemoService {
    @Override
    public String slowSayHello(String name) {
        return "Hello, "+name+"(slow say hello from api module)";
    }
}
