package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/12/7.
 */
public class CancledTest {
    static Runnable test= () -> {
        for (int i = 0; i < 1000000000; i++) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("cancled");
                break;
            }
            System.out.println("run"+i);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<?> future = service.submit(test);
        TimeUnit.SECONDS.sleep(1);
        future.cancel(true);


    }
}
