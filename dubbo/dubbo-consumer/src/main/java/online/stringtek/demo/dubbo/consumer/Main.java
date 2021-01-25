package online.stringtek.demo.dubbo.consumer;

import jdk.nashorn.internal.ir.annotations.Reference;
import online.stringtek.demo.dubbo.api.DemoService;
import online.stringtek.demo.dubbo.consumer.config.DubboConfig;
import online.stringtek.demo.dubbo.consumer.service.ConsumerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(DubboConfig.class);
        ConsumerService consumerService = ctx.getBean(ConsumerService.class);
        System.out.println(consumerService.getDemoService().sayHello("StringTek"));
        System.out.println(consumerService.getSleepDemoService().slowSayHello("StringTek"));
    }
}
