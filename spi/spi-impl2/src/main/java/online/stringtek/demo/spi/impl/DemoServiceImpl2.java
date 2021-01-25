package online.stringtek.demo.spi.impl;

import online.stringtek.demo.spi.api.DemoService;

public class DemoServiceImpl2 implements DemoService {
    @Override
    public void fuck() {
        System.out.println("fuck from impl 2");
    }
}
