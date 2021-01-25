package online.stringtek.demo.dubbo.provider;

import online.stringtek.demo.dubbo.provider.config.DubboProviderConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(DubboProviderConfig.class);
        System.in.read();
    }
}
