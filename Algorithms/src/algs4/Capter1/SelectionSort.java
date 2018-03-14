package algs4.Capter1;

/**
 * Created by CS on 2018/3/7.
 */
public class SelectionSort implements Sort {
    @Override
    public Sort sort() {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exch(i, min);
        }
        return this;
    }

    public static void main(String[] args) {
        new SelectionSort().sort().show();

    }
}
