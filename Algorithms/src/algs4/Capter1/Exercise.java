package algs4.Capter1;

/**
 * Created by CS on 2017/10/26.
 */
public class Exercise {
    @Ex("1.1.20")
    public static double ln(int n) {
        if (n == 0) return 0;
        else return Math.log(n)+ln(n-1);
    }
}
