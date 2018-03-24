package algs4;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by CS on 2017/10/25.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new test().getClass().getResource(""));
        System.out.println(new test().getClass().getResource("/"));
        System.out.println(new test().getClass().getClassLoader().getResource(""));
        System.out.println(new test().getClass().getClassLoader());
        char a = '一';
        char a1 = 'A';
        System.out.println(a - 0);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        new Random().ints(1, 4).limit(3).forEach(System.out::println);
//        Collections.shuffle();
    }
}
