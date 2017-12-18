package concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by CS on 2017/12/17.
 */
public class CasNumberRange {
    private static class IntPair {
        final int lower;
        final int upper;

        public IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    private final AtomicReference<IntPair> values = new AtomicReference<>();

    public void setLower(int i) {
        while (true) {
            IntPair old = values.get();
            if (i > old.upper) throw new IllegalArgumentException("cannot set lower ");
            IntPair pair = new IntPair(i, old.upper);
            if (values.compareAndSet(old, pair)) return;
        }
    }
}
