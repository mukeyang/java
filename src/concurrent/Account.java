package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/12/11.
 * fake class for test deadlock
 */
public class Account {
    public ReentrantLock lock;

    public Integer getBanlance() {
        return 0;
    }

    public void debit(int amount) {

    }

    public void credit(int amount) {

    }
}
