import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by CS on 2017/9/29.
 */

class fg {
    private int i;
    public void show() {
        System.out.println("fg");
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public fg(int i) {
        this.i = i;
    }
}
public class test929 extends fg{
    @Override
    public void show() {
        super.show();
    }

    public int i;
    public test929(int i) {
        super(i);
    }

    public static void main(String[] args) {
        TreeSet<String> strings = new TreeSet<>(Arrays.asList("abc","hh","cde","fgh"));
        System.out.println(strings.size());
        System.out.println(strings.first());
        strings.forEach(System.out::println);
//        strings.forEach(System.out::println);
//        System.out.println(new test929(3).getI());
    }
}
