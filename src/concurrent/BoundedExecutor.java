package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/**
 * Created by CS on 2017/12/8.
 */
public class BoundedExecutor {
    private final Executor exec;
    private final Semaphore sem;

    public BoundedExecutor(Executor exec, Semaphore sem) {
        this.exec = exec;
        this.sem = sem;
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        sem.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } finally {
                        sem.release();
                    }
                }
            });
        } catch (Exception e) {
            sem.release();
        }
    }
}
