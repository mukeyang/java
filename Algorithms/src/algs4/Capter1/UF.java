package algs4.Capter1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by CS on 2018/3/12.
 */
public class UF {
    public int[] data;

    public UF(int N) {
        data = IntStream.range(0, N).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new UF(30).data));
    }
}
