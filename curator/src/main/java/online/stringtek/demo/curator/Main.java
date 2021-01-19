package online.stringtek.demo.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Main {
    public static void main(String[] args) {
        //工厂模式建立链接
        CuratorFramework curator = CuratorFrameworkFactory.newClient("localhost:2181", new ExponentialBackoffRetry(1000, 3));
        curator.start();
        curator.usingNamespace("curator");
        //builder模式简历链接
//        CuratorFramework curator = CuratorFrameworkFactory.builder()
//                .connectString("localhost:2181")
//                .retryPolicy(new ExponentialBackoffRetry(1000,3))
//                .namespace("curator")
//                .build();
//        curator.start();
        System.out.println("zookeeper server connected.");
    }
}
