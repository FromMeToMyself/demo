package online.stringtek.demo.dubbo.spi.api;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface HelloService {
    void sayHello();
}
