package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/10/21.
 */
public class Barriertest {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int count=3;
    public void ss() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread()+""+1);
            if(--count==0)
                condition.signalAll();
            else condition.await();
            System.out.println(Thread.currentThread()+""+2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Barriertest barriertest = new Barriertest();
//        new Thread(barriertest::ss,"a").start();
//        new Thread(barriertest::ss,"b").start();
//        new Thread(barriertest::ss,"c").start();
//        Thread.currentThread().sleep(20);
 CyclicBarrier cb = new CyclicBarrier(3,()->System.out.println("gg"));
        new Thread(() -> {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();new Thread(() -> {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();new Thread(() -> {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
