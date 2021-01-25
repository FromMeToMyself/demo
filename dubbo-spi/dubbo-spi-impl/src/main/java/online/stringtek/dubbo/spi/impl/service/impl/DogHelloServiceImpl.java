package online.stringtek.dubbo.spi.impl.service.impl;

import online.stringtek.demo.dubbo.spi.api.HelloService;
import org.apache.dubbo.common.extension.SPI;


public class DogHelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("woof");
    }
}
