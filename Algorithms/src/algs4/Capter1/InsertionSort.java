package algs4.Capter1;

/**
 * Created by CS on 2018/3/7.
 */
public class InsertionSort implements Sort {

    @Override
    public Sort sort() {
//        for (int i = 0; i < a.length; i++) {
//            for(int j=i;j>0&&less(a[j],a[j-1]);j--)
//                exch(j,j-1);
//        }
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            for (; j > 0 && a[j] > temp; j--) a[j + 1] = a[j];
            a[j + 1] = temp;
        }
        return this;
    }

    public static void main(String[] args) {
        new InsertionSort().sort().show();
    }
}
