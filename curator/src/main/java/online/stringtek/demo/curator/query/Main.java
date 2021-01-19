package online.stringtek.demo.curator.query;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("curator")
                .build();
        curator.start();
        Stat stat=new Stat();
        byte[] bytes = curator.getData().storingStatIn(stat).forPath("/query-demo");
        System.out.println(new String(bytes));
        System.out.println(stat);
    }
}
