package online.stringtek.demo.dubbo.provider.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "online.stringtek.demo.dubbo.provider.service.impl")
@PropertySource("classpath:/dubbo-provider.properties")
public class DubboProviderConfig {

}
