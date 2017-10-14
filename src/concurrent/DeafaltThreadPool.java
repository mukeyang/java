package concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by CS on 2017/10/14.
 */
public class DeafaltThreadPool<job extends Runnable> implements ThreadPool<job> {
    private static final int MAX=10;
    private static final int deafute = 5;
    private static final int Min = 1;
    private final LinkedList<job> jobs = new LinkedList<>();
    private final List<Woker> wokers = Collections.synchronizedList(new ArrayList<Woker>());
    private int wokerNum = deafute;
    private AtomicLong threadNUm = new AtomicLong();

    private void initializeWokers(int wokerNum) {
        for (int i = 0; i < wokerNum; i++) {
            Woker woker = new Woker();
            wokers.add(woker);
            Thread thread = new Thread(woker, "ThreadPool-Woker-" + threadNUm.incrementAndGet());
            thread.start();
        }
    }

    public DeafaltThreadPool() {
        initializeWokers(deafute);
    }
    public DeafaltThreadPool(int num) {
        wokerNum=num>MAX? MAX:num<Min?Min:num;
        initializeWokers(wokerNum);
    }

    @Override
    public void execute(job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Woker woker : wokers) {
            woker.shutdown();
        }
    }

    @Override
    public int size() {
        return jobs.size();
    }

    @Override
    public void removeWoker(int num) {
        synchronized (jobs) {
            if (num >= wokerNum) {
                throw new IllegalArgumentException("beyond ");
            }
            int count=0;
            while (count < num) {
                Woker woker = wokers.get(num);
                if (wokers.remove(woker)) {
                    woker.shutdown();
                    count++;
                }
            }
            wokerNum-=count;
        }

    }

    @Override
    public void addwokers(int num) {

    }
    class Woker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                job job=null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
//                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try  {
                        job.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }                }
            }

        }

        public void shutdown() {
            running=false;
        }
    }

}
