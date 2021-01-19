package online.stringtek.demo.curator.create;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("curator")
                .build();
        curator.start();
        System.out.println("zookeeper server connected");
        curator.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/curator-node/layer-1/layer-2","curator-node".getBytes(StandardCharsets.UTF_8));
    }
}
