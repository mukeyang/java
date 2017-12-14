package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/12/14.
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if(!isEmpty()) return doTake();
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
