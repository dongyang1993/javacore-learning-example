package org.core.zookeeper;

public class DistributedLock2Test {

    public void test() throws Exception {
        DistributedLock2 lock2 = new DistributedLock2();

        try {
            if (lock2.lock("testlock", "BatchInsertTest", 10)) {
                System.out.println(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock2.unlock("kft", "BatchDebitKFT");
        }
    }
}
