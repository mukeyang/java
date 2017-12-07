package concurrent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by CS on 2017/12/6.
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(Semaphore sem) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.sem = sem;
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdder = false;
        try {
            wasAdder = set.add(o);
            return wasAdder;
        }finally {
            if (!wasAdder) sem.release();

        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }
}
