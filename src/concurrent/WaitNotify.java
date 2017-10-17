package concurrent;

import jvm.SleepUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by CS on 2017/10/13.
 */
public class WaitNotify {
    static boolean flag=true;
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Wait(),"wait").start();
        new Thread(new NOtiofy(),"wait1").start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
//                        DateTimeFormatter.of
                        System.out.println("flag true");
//                        System.out.println(LocalTime.now());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("flag false");
            }
        }
    }

    static class NOtiofy implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify");
                lock.notifyAll();
                flag=false;
                SleepUtils.second(5);

            }
            synchronized (lock) {
                System.out.println("again");
                SleepUtils.second(5);
            }
        }
    }

}

class Mutex1 implements Lock {
    private static final class sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
//            return super.tryAcquire(arg);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0||getExclusiveOwnerThread()!=Thread.currentThread()) {
                throw new IllegalMonitorStateException();
            }

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
    }
    @Override
    public void lock() {


    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}