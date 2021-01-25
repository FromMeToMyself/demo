package online.stringtek.demo.dubbo.spi.main;

import online.stringtek.demo.dubbo.spi.api.HelloService;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ExtensionLoader<HelloService> extensionLoader= ExtensionLoader.getExtensionLoader(HelloService.class);
        Set<String> supportedExtensions = extensionLoader.getSupportedExtensions();
        for (String extension : supportedExtensions) {
            extensionLoader.getExtension(extension).sayHello();
        }
    }
}
