package zhihu;

import org.junit.Test;

/**
 * Created by CS on 2017/9/19.
 */
public class week1 {
    @Test
    public void test1() {
//        System.out.println(1<<31);
        int n=-32;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(32));
        StringBuilder result=new StringBuilder();
        while (n !=0) {
            result.append(n%2);
            n=n/2;
        }
        System.out.println(result.reverse());
    }
    public static void main(String[] args) {

    }
}
