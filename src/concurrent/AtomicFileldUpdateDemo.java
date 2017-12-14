package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by CS on 2017/12/11.
 */
public class AtomicFileldUpdateDemo {
    public static class Candidate {
        int id;
        volatile int score;
    }

    public static AtomicInteger allScore = new AtomicInteger(0);
    public final static AtomicIntegerFieldUpdater<Candidate> score = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] t = new Thread[10000];
        for (int i = 0; i < t.length; i++) {
            t[i] =new Thread() {
                @Override
                public void run() {
                    if (Math.random() > 0.4) {
                        score.incrementAndGet(stu);
                        allScore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }
        for (Thread thread : t) {
            thread.join();
        }
        System.out.println(stu.score+"==="+allScore);
    }
}
