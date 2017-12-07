package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by CS on 2017/12/6.
 */
public class TestLatch {
    public long timeTasks(int nthreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nthreads);
        for (int i = 0; i < nthreads; i++) {
            Thread t=new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
