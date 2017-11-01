package concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/10/28.
 */
public class test1 {
    @Test
    public void ss() throws InterruptedException {
        C1 c1 = new C1();
        Thread thread = new Thread(c1);
        thread.start();
//        TimeUnit.SECONDS.sleep(1);
        c1.suspend();
        TimeUnit.SECONDS.sleep(1);
        c1.resume();
    }
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());

            }
        });
thread.start();
        thread.interrupt();

    }
}

class C1 implements Runnable {
    volatile boolean suspend = false;
    static Object lock = new Object();

    public void suspend() {
        suspend = true;
    }

    public void resume() {
        suspend=false;
        synchronized (this) {
            notify();
        }
    }
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (suspend) {
                    try {
                        System.out.println("wait");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (lock) {
//                if (suspend)
                System.out.print(".");
                Thread.yield();
            }
        }
    }
}
