package concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by CS on 2017/10/14.
 */
public class NumberRange {
    private static class IntPair {
        final int low;
        final int high;

        public IntPair(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    private AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0, 0));

    public void setLower(int i) throws Exception {
        for (;;) {
            IntPair pair = values.get();
            if(i> pair.high) throw new Exception();
            IntPair newPair = new IntPair(i, pair.high);
            if(values.compareAndSet(pair,newPair)) return;
        }
    }
}
