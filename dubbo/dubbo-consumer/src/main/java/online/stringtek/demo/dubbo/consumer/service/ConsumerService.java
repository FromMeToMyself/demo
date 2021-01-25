package online.stringtek.demo.dubbo.consumer.service;

import lombok.Data;
import online.stringtek.demo.dubbo.api.DemoService;
import online.stringtek.demo.dubbo.api.SleepDemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;


@Data
@Service
public class ConsumerService {
    @DubboReference
    private DemoService demoService;
    @DubboReference(mock = "true",timeout = 1000,retries = 1)
    private SleepDemoService sleepDemoService;
}
