package concurrent;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

/**
 * Created by CS on 2017/12/8.
 */
public class LogService {
    private final BlockingQueue<String> queue;
    private LogThread thread;
    private final PrintWriter writer;
    private boolean isShutDown;
    private int reservations;

    public LogService(BlockingQueue<String> queue, PrintWriter writer, boolean isShutDown, int reservations) {
        this.queue = queue;
        this.writer = writer;
        this.isShutDown = isShutDown;
        this.reservations = reservations;
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutDown = true;
        }
        thread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if(isShutDown) throw new IllegalStateException();
            ++reservations;
        }
        queue.put(msg);
    }
    private class LogThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutDown && reservations == 0) break;
                            }
                        String msg=queue.take();
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        writer.println(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } finally {
                writer.close();
            }
        }
        }
    }

