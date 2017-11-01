package concurrent;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/10/26.
 */
public class TPoolDemo {
    @Test
    public void testSchedule() throws InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        System.out.println(System.currentTimeMillis());
        service.scheduleAtFixedRate(() -> System.out.println(System.currentTimeMillis()), 0,1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("dealy"+System.currentTimeMillis());}, 0,1, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(10);
    }
    public static void main(String[] args) {
        ThreadPoolExecutor pool = ((ThreadPoolExecutor) Executors.newFixedThreadPool(3));
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(pool.getTaskCount());
        System.out.println(pool.getPoolSize());
        System.out.println(pool.getActiveCount());
        System.out.println(pool.getCompletedTaskCount());
    }
}
