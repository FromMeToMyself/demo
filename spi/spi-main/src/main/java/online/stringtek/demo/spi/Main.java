package online.stringtek.demo.spi;

import online.stringtek.demo.spi.api.DemoService;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<DemoService> serviceLoader=ServiceLoader.load(DemoService.class);
        if(serviceLoader.iterator().hasNext()){
            DemoService demoService = serviceLoader.iterator().next();
            demoService.fuck();
        }
    }
}
