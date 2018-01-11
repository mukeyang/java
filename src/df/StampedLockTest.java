package df;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by CS on 2018/1/11.
 */
public class StampedLockTest {
    class point {
        private double x,y;
        private final StampedLock s1 = new StampedLock();

        void move(double delatX, double deltaY) {
            long stamp = s1.writeLock();
            try {
                y += deltaY;
                x += delatX;
            } finally {
                s1.unlockWrite(stamp);
            }
        }

        double distanceFromOrigin() {
            long stamp = s1.tryOptimisticRead();
            double currentX = x, currentY = y;
            if (!s1.validate(stamp)) {
                stamp = s1.readLock();
                try {
                    currentX = x;
                    currentY=y;
                } finally {
                    s1.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        void moveIfAtOrigin(double newX, double newY) {
            long stamp = s1.readLock();
            try {
                while (x == 0.0 && y == 0.0) {
                    long ws = s1.tryConvertToWriteLock(stamp);
                    if (ws != 0L) {
                        stamp=ws;
                        x = newX;
                        y = newY;
                        break;
                    }
                    else {
                        s1.unlockRead(stamp);
                        stamp = s1.writeLock();
                    }
                }
            } finally {
                s1.unlock(stamp);
            }
        }

    }
}
