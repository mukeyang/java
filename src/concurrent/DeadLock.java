package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/12/11.
 */
public class DeadLock {
    public void transferMoney(final Account from, final Account to, final int amount) {
        class helper{
            public void transfer() {
                if(from.getBanlance().compareTo(amount)<0) return;
                else {
                    from.debit(amount);
                    to.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        if (fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
                    new helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
                    new helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (from) {
                    synchronized (to) {
                        new helper().transfer();

                    }
                }
            }
        }
    }

    public boolean transferMoney(Account from, Account to, int amount, long timeout, TimeUnit unit) {
        long stopTime = System.nanoTime() + unit.toNanos(timeout);
        while (true) {
            if (from.lock.tryLock()) {
                try {
                    if (to.lock.tryLock()) {
                        try {
                            if (from.getBanlance().compareTo(amount)>0) {
                                //TODO
                            }
                        } finally {
                            to.lock.unlock();
                        }
                    }
                } finally {
                    from.lock.unlock();
                }
            }
            if(System.nanoTime()>stopTime) return false;
        }
    }
    private static final Object tieLock = new Object();
}
