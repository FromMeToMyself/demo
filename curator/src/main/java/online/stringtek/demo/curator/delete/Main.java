package online.stringtek.demo.curator.delete;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Main {
    public static void main(String[] args) throws Exception {
        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("curator")
                .build();
        curator.start();
        //删除一个节点
        curator.delete().forPath("/demo-1");
        //递归删除
//        curator.delete().deletingChildrenIfNeeded().forPath("/curator-node");
    }
}
