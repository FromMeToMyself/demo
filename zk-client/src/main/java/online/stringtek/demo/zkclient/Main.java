package online.stringtek.demo.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = new ZkClient("localhost:2181");

        boolean exists = zkClient.exists("/zk-client-demo");
        if(exists){
            //读取节点内容
            Object o = zkClient.readData("/zk-client-demo");
            System.out.println(o);
            //递归删除
            zkClient.deleteRecursive("/zk-client-demo");
        }
        zkClient.createPersistent("/zk-client-demo","1",ZooDefs.Ids.OPEN_ACL_UNSAFE);
        //递归创建
        zkClient.createPersistent("/zk-client-demo/layer-1/layer-2",true, ZooDefs.Ids.OPEN_ACL_UNSAFE);

        //获取子节点列表
        List<String> children = zkClient.getChildren("/zk-client-demo");
        System.out.println(children);

        //可监听不存在的节点，该节点本身创建或者删除都会触发，子节点变化也会触发
        zkClient.subscribeChildChanges("/zk-client-demo", new IZkChildListener() {
            @Override
            public void handleChildChange(String parent, List<String> list) throws Exception {
                System.out.println(parent+":"+list);
            }
        });
        zkClient.subscribeChildChanges("/zk-client-listener-demo", new IZkChildListener() {
            @Override
            public void handleChildChange(String parent, List<String> list) throws Exception {
                System.out.println(parent+":"+list);
            }
        });
        zkClient.subscribeDataChanges("/data-change-demo", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("节点："+s+"的内容发生变化，新的内容为"+o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("节点："+s+"被删除");
            }
        });
        Thread thread = new Thread(() -> {
            try {
                zkClient.create("/zk-client-demo/hahaha","hahaha",ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                Thread.sleep(1000);
                zkClient.create("/zk-client-listener-demo","listener",CreateMode.EPHEMERAL);
                Thread.sleep(1000);
                zkClient.create("/data-change-demo","123",CreateMode.PERSISTENT);
                Thread.sleep(1000);
                zkClient.delete("/data-change-demo");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
    }
}
