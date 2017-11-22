package jvm;

/**
 * Created by CS on 2017/11/3.
 */
public class NotInit {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
class superClass{
    public static int value=123;
    static {
        System.out.println("super");
    }
}

class SubClass extends superClass {
    static {
        System.out.println("sub");
    }
}