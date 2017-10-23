package concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CS on 2017/10/22.
 */
public class exchangeTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Exchanger<String> exchanger = new Exchanger<>();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "a";
                try {
                    String s = exchanger.exchange(A);
                    System.out.println("s"+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String b = "BB";
                try {
                    String a = exchanger.exchange(b);
                    System.out.println(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
