package concurrent;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/10/16.
 */
public class lockTest {
    @Test
    public void ss() {
        double a=3.1;
        System.out.println(a==3.1);
    }
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition notempty = lock.newCondition();

        //add exception by submit
        ThreadPoolExecutor pool=new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t == null && r instanceof Future<?>) {
                    try {
                        Object o = ((Future<?>) r).get();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e) {
                        t = e.getCause();
                    } catch (CancellationException e) {
                        t=e;
                    }
                }
                if (t != null) {
                    t.printStackTrace();
                }
            }
        };

    }
}
