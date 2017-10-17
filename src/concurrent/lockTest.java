package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CS on 2017/10/16.
 */
public class lockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition notempty = lock.newCondition();


    }
}
