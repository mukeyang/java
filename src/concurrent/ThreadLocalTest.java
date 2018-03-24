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

    public static void main(String[] args) {
        String s = "hello world";
        for (int i = 0; i < 10000; i++) {
            s += i;
        }
        System.out.println(s);
    }
}
