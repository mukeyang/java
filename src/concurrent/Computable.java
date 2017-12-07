package concurrent;

/**
 * Created by CS on 2017/12/6.
 */
public interface Computable<A, V> {
    V compute(A arg)throws InterruptedException;
}
