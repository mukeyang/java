package concurrent;

import java.util.Properties;

/**
 * Created by CS on 2017/10/12.
 */
public class Shutdown {
    private static class Runner implements Runnable {
        private long i;
        private volatile  boolean on =true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i ="+i);
        }

        public void cancel() {
            on=false;
        }
    }

    public static void main(String[] args) throws Exception {
//        Runner one=new Runner();
//        Thread thread = new Thread(one, "count-thread");
//        thread.start();
//        TimeUnit.SECONDS.sleep(1);
//        thread.interrupt();
//        Runner two = new Runner();
//        thread = new Thread(two, "count-thread");
//        thread.start();
//        TimeUnit.SECONDS.sleep(1);
//        two.cancel();
//        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        lock.readLock().unlock();
        Properties properties = System.getProperties();
        properties.setProperty("1", "1");
        System.out.println(properties.getProperty("1"));
    }
}
