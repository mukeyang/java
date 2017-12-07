package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by CS on 2017/12/7.
 */
public class LockSupportDemo {
    public static Object u = new Object();
    static Change t1 = new Change("t1");
    static Change t2 = new Change("t2");
    public static class Change extends Thread {
        public Change(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in--" + getName());
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);//先调用也行
        t1.join();
        t2.join();
    }
}
