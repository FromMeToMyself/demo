package online.stringtek.demo.dubbo.consumer.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "online.stringtek.demo.dubbo.consumer")
@PropertySource("classpath:/dubbo-consumer.properties")
@ComponentScan(basePackages = "online.stringtek.demo.dubbo.consumer")
public class DubboConfig {
}
