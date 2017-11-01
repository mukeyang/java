package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/10/29.
 */
public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            System.out.println("interrupt"+Thread.currentThread().getName());

        } finally {
            if(lock1.isHeldByCurrentThread()) lock1.unlock();
            if(lock2.isHeldByCurrentThread()) lock2.unlock();
            System.out.println(Thread.currentThread().getName()+"exit");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock lock = new IntLock(1);
        IntLock lock2 = new IntLock(2);
        Thread t1 = new Thread( lock,"1");
        Thread t2 = new Thread( lock2,"2");
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
    }
}

