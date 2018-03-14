package algs4;

/**
 * Created by CS on 2017/10/25.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new test().getClass().getResource(""));
        System.out.println(new test().getClass().getResource("/"));
        System.out.println(new test().getClass().getClassLoader().getResource(""));
        System.out.println(new test().getClass().getClassLoader().getResource("/"));
    }
}
