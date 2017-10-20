package concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by CS on 2017/10/17.
 */
public class TwinsLock {
    private static final class sync extends AbstractQueuedSynchronizer {
        sync(int count) {
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;) {
                int count = getState();
                int newt = count - arg;
                if (newt < 0 || compareAndSetState(count, newt)) {
                    return newt;
                }
            }
//            return super.tryAcquireShared(arg);


        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newcurrent = current + arg;
                if (compareAndSetState(current, newcurrent)) {
                    return true;
                }
            }
//            return super.tryReleaseShared(arg);
        }
    }


}

class tips extends AbstractQueuedSynchronizer{
   /* //semaphore implement
    protected int tryAcquireShared(int arg) {
        for (;;) {
//            if (hasQueuedPredecessors()) {
//                return -1;
//            }
            int available = getState();
            int remaining = available - arg;
            if (remaining < 0 || compareAndSetState(available, remaining)) {
                return remaining;
            }
        }
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        for (;;) {
            int current = getState();
            int next=current+arg;
            if(next<current) throw new Error("maximum permit count exceeded");
            if (compareAndSetState(current, next)) {
                return true;
            }
        }
//        return super.tryReleaseShared(arg);
    }*/

    @Override
    protected int tryAcquireShared(int arg) {
        return (getState()==0)? 1:-1;
//        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        for (;;) {
            int c = getState();
            if (c == 0) return false;

            int next = c - arg;
            if (compareAndSetState(c, next)) {
                return next == 0;
            }
        }
//        return super.tryReleaseShared(arg);
    }
}