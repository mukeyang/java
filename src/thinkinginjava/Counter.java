package thinkinginjava;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by CS on 2017/10/7.
 */
public class Counter {
    private int i=0;
    private int i2=0;
    private AtomicInteger atomic = new AtomicInteger(0);

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        final Counter cas = new Counter();
        ArrayList<Thread> list = new ArrayList<>(600);
        long l = System.currentTimeMillis();
        for (int i1 = 0; i1 < 100; i1++) {
            list.add(new Thread(() -> {
                for (int i2 = 0; i2 < 100; i2++) {
                    cas.count();
                    cas.safeCount();
                    cas.count1();
                }
            }));

        }
        list.forEach(Thread::start);
        list.forEach(a -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(cas.i);
        System.out.println(cas.i2);
        System.out.println(cas.atomic.get());
        System.out.println(System.currentTimeMillis()-l);
    }

    private void count() {
//        System.out.println(i);
        i++;
    }   private synchronized void count1() {
//        System.out.println(i);
        i2++;
    }

    private void safeCount() {
//        System.out.println("get"+atomic.get());
        for (; ; ) {
            int j = atomic.get();
            boolean b = atomic.compareAndSet(j, ++j);
            if (b) {
                break;
            }
        }
    }
}
