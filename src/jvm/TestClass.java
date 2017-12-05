package jvm;

import java.util.List;

/**
 * Created by CS on 2017/11/2.
 */
public class TestClass {
    private int m;

    public int inc() {
        return m + 1;
    }

    public static void main(String[] args) {
        Integer i = 3;
        int j=i;
        i=j;
//        List<Integer>list=[1,2,3,4];
        System.out.println((int) 'm');

    }

    public static String m(List<String>a) {
        return null;
    }

//    public static int m(List<Integer> b) {
//        return 1;
//    }
}