package concurrent;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by CS on 2017/12/7.
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException{
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        finally {
            lock.unlock();
            return value;

        }
    }
    public void handleWrite(Lock lock,int index) throws InterruptedException {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            value = index;
        }
        finally {
            lock.unlock();


        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable read=()->{
            try {
                demo.handleRead(readLock);
                demo.handleRead(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable write=()->{
            try {
                demo.handleWrite(writeLock,new Random().nextInt());
                demo.handleWrite(lock,new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }
        for (int i = 18; i < 20; i++) {
            new Thread(write).start();
        }
    }

}
