package concurrent;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by CS on 2017/10/14.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int init) {
        if (init > 0) {
            for (int i = 0; i < init; i++) {
                pool.addLast(ConnectionDrive.createConnection());
            }
        }
    }

    public void relase(Connection con) {
        if (con != null) {
            synchronized (pool) {
                pool.addLast(con);
                pool.notifyAll();
            }
        }
    }
    public Connection fetch(long mils) throws InterruptedException {
        synchronized (pool) {
            if (mils <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeLast();
            } else {
                long future = System.currentTimeMillis() + mils;
                long remain=mils;
                while (pool.isEmpty() && remain > 0) {
                    pool.wait(remain);
                    remain = future - System.currentTimeMillis();
                }
                Connection result=null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}

class ConnectionPoolTest {
    static class ConnectionRunner implements Runnable{
    int count;
        AtomicInteger got;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notgot) {
            this.count = count;
            this.got = got;
            this.notgot = notgot;
        }

        AtomicInteger notgot;
        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                try {
                    Connection connection = pool.fetch(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.relase(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notgot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    count--;
                }
            }
            end.countDown();

        }
    }
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count=20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notgot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notgot), "connectionmRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println(got+"gg"+notgot);
    }
}
