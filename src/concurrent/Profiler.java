package concurrent;

import jvm.SleepUtils;

/**
 * Created by CS on 2017/10/13.
 */
public class Profiler {
    public static final ThreadLocal<Long> time = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        time.set(System.currentTimeMillis());
    }
    public static final Long end() {
        return System.currentTimeMillis() - time.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.second(5);
        System.out.println("cost"+Profiler.end());
    }
}
