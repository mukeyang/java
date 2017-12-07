package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/12/7.
 */
public class FairLock implements  Runnable{
    public static ReentrantLock fairLock = new ReentrantLock(false);

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"get");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        new Thread(r1).start();
        new Thread(r1).start();
    }
}
