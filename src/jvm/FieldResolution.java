package jvm;

/**
 * Created by CS on 2017/11/4.
 */
public class FieldResolution {

    interface i1 {
        int a=0;
    }

    interface i2 extends i1 {
        int a=1;
    }
    interface i3{
        int a=2;
    }

    static class P implements i1 {
        static  int a=3;
    }

    static class sub extends P implements i3 {
        static int a=4;// no commet will ambiguous
    }

    public static void main(String[] args) {
        System.out.println(sub.a);
    }
}

class test {
    public static void main(String[] args) {
        String s="123.class";
        System.out.println(s.substring(s.lastIndexOf('.') + 1));
        System.out.println(new test().getClass().getName());
    }
    static {
        i = 0;
        //illegal forward ref can set no get
        //System.out.println(i);
    }
    static int i=1;

}
