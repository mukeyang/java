package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/12/14.
 */
public class ConditionBoundedBuffer<V> {
    protected final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public ConditionBoundedBuffer(int buffer_size) {
        this.buffer_size = buffer_size;
    }
private int tail,head,count;
    private int buffer_size;
    private final V[] items = (V[]) new Object[buffer_size];

    public void put(V x) throws InterruptedException {
        lock.lock();
        try {
            while (count==items.length) notFull.await();
            items[tail] = x;
            if(++tail==items.length) tail = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public V take() throws InterruptedException {
        lock.lock();
        try {
            while (count==0) notEmpty.await();
            V item = items[head];
            items[head] = null;
            if(++head==items.length) head = 0;
            --count;
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }
}
