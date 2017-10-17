package concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/10/17.
 */
public class SimpleBlockingQueue<T> implements BlockingQueue<T> {
    final Object[] items;
    int takeIndex;
    int putIndex;
    int count;
    final ReentrantLock lock;

    public SimpleBlockingQueue(int count,boolean fair) {
        if(count<0) throw new IllegalArgumentException();
        items = new Object[count];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    private final Condition notFull;
    private final Condition notEmpty;
    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void put(T t) throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count==items.length) notFull.await();
            insert(t);
        }finally {
            lock.unlock();
        }

    }

    private void insert(T t) {
        items[putIndex] = t;
        if(++putIndex==items.length) putIndex=0;
        ++count;
        notEmpty.signal();
    }

    private T dequeue() {
        T result = (T)items[takeIndex];
        items[takeIndex]=null;//help gc
        if(++takeIndex==items.length) takeIndex=0;
        --count;
        notFull.signal();
        return result;
    }
    @Override
    public boolean offer(T t, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public T take() throws InterruptedException {
        lock.lockInterruptibly();

        try {
            while (count==0) notEmpty.await();
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public int drainTo(Collection<? super T> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super T> c, int maxElements) {
        return 0;
    }
}
