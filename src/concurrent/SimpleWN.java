package concurrent;

/**
 * Created by CS on 2017/12/5.
 */

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * simple demo use wait and notify
 */
public class SimpleWN {
    @Test
    public void hh() {
        try {
            Thread.currentThread().interrupt();
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().isInterrupted());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "T1 start");
                try {
                    System.out.println(System.currentTimeMillis() + "t1 wait for object");
                    TimeUnit.SECONDS.sleep(10);
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "t1 end");
            }
        }
    }

    public static class t2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "t2 start");
//                object.notify();
                System.out.println(System.currentTimeMillis()+"t2 end");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new T1().start();
        new t2().start();
    }
}
