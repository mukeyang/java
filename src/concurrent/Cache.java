package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by CS on 2017/10/18.
 */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}

class ff {
    static ReadWriteLock rtLock = new ReentrantReadWriteLock();
    volatile boolean update;

    public void processData() {
        Lock readLock = rtLock.readLock();
        Lock writeLock = rtLock.writeLock();
        readLock.lock();
        if (!update) {
            readLock.unlock();
            writeLock.lock();
            try {
                if (!update) {
                    update = true;
                }
                readLock.lock();
            } finally {
                writeLock.unlock();
            }

        }
        try {

        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        System.out.println("get readLock.");
        rtLock.writeLock().lock();
        System.out.println("blocking");
    }
}
