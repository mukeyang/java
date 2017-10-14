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
    private static final int defaulte = 5;
    private static final int Min = 1;
    private final LinkedList<job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    private int wokerNum = defaulte;
    private AtomicLong threadNUm = new AtomicLong();

    private void initializeWokers(int wokerNum) {
        for (int i = 0; i < wokerNum; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNUm.incrementAndGet());
            thread.start();
        }
    }

    public DeafaltThreadPool() {
        initializeWokers(defaulte);
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
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public int size() {
        return jobs.size();
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num >= wokerNum) {
                throw new IllegalArgumentException("beyond ");
            }
            int count=0;
            while (count < num) {
                Worker worker = workers.get(num);
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            wokerNum-=count;
        }

    }

    @Override
    public void addworkers(int num) {
        synchronized (jobs) {
            if (num + wokerNum > MAX) {
                num = MAX - wokerNum;
            }
            initializeWokers(num);
            wokerNum+=num;
        }

    }
    class Worker implements Runnable {
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
