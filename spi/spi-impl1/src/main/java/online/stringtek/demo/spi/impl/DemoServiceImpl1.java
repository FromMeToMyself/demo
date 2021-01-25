package online.stringtek.demo.spi.impl;

import online.stringtek.demo.spi.api.DemoService;

public class DemoServiceImpl1 implements DemoService {
    @Override
    public void fuck() {
        System.out.println("fuck from impl 1");
    }
}
