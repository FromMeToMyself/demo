package online.stringtek.demo.dubbo.provider.service.impl;

import online.stringtek.demo.dubbo.api.SleepDemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class SleepDemoServiceImpl implements SleepDemoService {
    @Override
    public String slowSayHello(String name) {
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, "+name;
    }
}
