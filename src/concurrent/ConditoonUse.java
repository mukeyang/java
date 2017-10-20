package concurrent;

import jvm.SleepUtils;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/10/19.
 */
public class ConditoonUse {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public void cwait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
            System.out.println("wait");
        } finally {
            lock.unlock();
        }
    }
    public void  cs() {
        lock.lock();
        try {
            condition.signal();
            System.out.println("signal");
            System.out.println(System.currentTimeMillis());
            SleepUtils.second(5);
            System.out.println(System.currentTimeMillis());


//            Thread.currentThread().sleep();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(5);
        new Thread(() -> {
            try {
                new ConditoonUse().cwait();
                System.out.println("123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start(); new Thread(() -> {

                new ConditoonUse().cs();
            System.out.println("cs");

        }).start();
        SleepUtils.second(10);
    }
}
