package concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by CS on 2017/12/11.
 */
public class AtomicArrayDemo {
    static AtomicIntegerArray array = new AtomicIntegerArray(10);

    public static class Add implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                array.getAndIncrement(i % array.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = new Thread(new Add());
            ts[i].start();
        }
        for (int i = 0; i < ts.length; i++) {
            ts[i].join();
        }
        System.out.println(array);
    }
}
