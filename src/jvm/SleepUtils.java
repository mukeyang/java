package jvm;

import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/10/12.
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


