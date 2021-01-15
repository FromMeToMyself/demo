package online.stringtek.demo.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZKUtil {
    public static ZooKeeper connect() throws IOException, InterruptedException {
        final CountDownLatch countDownLatch=new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 4000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState()==Event.KeeperState.SyncConnected) {
                    System.out.println("zookeeper server connected");
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        return zooKeeper;
    }

    public static String create(ZooKeeper zooKeeper, String path, byte[] data, List<ACL> acl, CreateMode createMode) throws KeeperException, InterruptedException {
        return zooKeeper.create(path,data,acl,createMode);
    }
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = connect();
        System.out.println(create(zooKeeper, "/zk-demo-per-seq-node","per-seq".getBytes(StandardCharsets.UTF_8),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL));
        System.out.println(create(zooKeeper, "/zk-demo-per-node", "per".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
        System.out.println(create(zooKeeper, "/zk-demo-seq-tmp-node", "tmp-seq".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL));
        System.out.println(create(zooKeeper, "/zk-demo-tmp-node", "tmp".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL));
    }
}
