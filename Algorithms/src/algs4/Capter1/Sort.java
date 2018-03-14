package algs4.Capter1;

import java.util.Arrays;

/**
 * Created by CS on 2018/3/7.
 */
public interface Sort {
    Integer[] a = {1, 5, 2, 4, 3};

    default boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    Sort sort();

    default void exch(int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = (Integer) t;
    }

    default void show() {
        System.out.println(Arrays.toString(a));
    }


}
