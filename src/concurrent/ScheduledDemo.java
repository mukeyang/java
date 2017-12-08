package concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/12/7.
 */
public class ScheduledDemo {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
//        pool.scheduleAtFixedRate(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println(System.currentTimeMillis());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 0, 2, TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
