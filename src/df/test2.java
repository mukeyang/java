package df;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CS on 2018/1/10.
 */

public class test2 {
    int[] a1 = new int[10];

    @Test
    public void t() {
//        int[] a = new int[10];
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(a1));
//        System.out.println(String.format("%1d,年后%1d", 12, 34));
        System.out.println(Arrays.toString("a,b,c,d,e".split(",", 1)));
        System.out.println(Arrays.toString("a,b,c,d,e".split(",", 2)));
        System.out.println(Arrays.toString("a,b,c,d,e".split(",", 3)));
    }
}


