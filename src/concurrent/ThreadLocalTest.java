package concurrent;

import java.text.SimpleDateFormat;

/**
 * Created by CS on 2018/3/14.
 */
public class ThreadLocalTest {
    static volatile ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected void finalize() throws Throwable {
            System.out.println(toString() + "gc");
        }
    };
}
