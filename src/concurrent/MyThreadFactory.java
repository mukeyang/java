package concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by CS on 2017/12/8.
 */
public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}

class MyThread extends Thread {
    public static final String name = "MyAppThread";
    public static volatile boolean debugLifeCycle = false;
    public static final AtomicInteger created = new AtomicInteger();
    public static final AtomicInteger alive = new AtomicInteger();
    public static final Logger log = Logger.getAnonymousLogger();

    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        boolean debug = debugLifeCycle;
        if(debug) log.log(Level.FINE, "created" + getName());
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if(debug) log.log(Level.FINE, "exited" + getName());

        }
    }

    public MyThread(Runnable runnable, String name) {
        super(runnable, name + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.log(Level.SEVERE, "uncaugfht" + t.getName(), e);
            }
        });

    }
}