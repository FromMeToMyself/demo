package online.stringtek.demo.curator.update;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
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
        String nodePath="/update-demo";
        curator.create().withMode(CreateMode.EPHEMERAL).forPath(nodePath,"before-update".getBytes(StandardCharsets.UTF_8));
        Stat stat=new Stat();
        byte[] bytes = curator.getData().storingStatIn(stat).forPath(nodePath);
        System.out.println("before update the value is "+new String(bytes));
        curator.setData().withVersion(stat.getVersion()).forPath(nodePath,"after-update".getBytes(StandardCharsets.UTF_8));
        bytes = curator.getData().forPath(nodePath);
        System.out.println("after update the value is "+new String(bytes));
        //触发BadVersionException
        curator.setData().withVersion(stat.getVersion()).forPath(nodePath,"exception".getBytes(StandardCharsets.UTF_8));
    }
}
