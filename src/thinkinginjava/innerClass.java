package thinkinginjava;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by CS on 2017/8/25.
 */
interface  selector<T>{
    boolean end();

    T current();

    void next();

}

class Sequence<U> {
    static  class  df{
        static  int j=1;
    }

    //cover return
    public static int f() {
        try {
            df.j=3;
            return 2;
        }
        finally {
            return 0;
        }
    }
    private Object[] items;
    private int next=0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(U x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public class sequenceSelector<U> implements selector<U> {
        private  int i=0;

        @Override
        public boolean end() {
            return i==items.length;
        }

        @Override
        public U current() {
            return (U)items[i];
        }

        @Override
        public void next() {
            if(i<items.length)
                i++;
        }

        public Sequence get() {
            return Sequence.this;
        }
    }

    public selector<U> selector() {
        return new sequenceSelector<U>();
    }

    public void test() {
        InputStream in = null;
        try{
        try {
           in=new FileInputStream("");
        }
        finally {
            in.close();
        }
    }
        catch (IOException e) {
            e.printStackTrace();
        }
    }




}
interface dd{

    void s();
    static class Test implements dd{
        @Override
        public void s() {
            System.out.println("gg");
        }

        public static void main(String[] args) {
            new Test().s();
        }
    }

}

class Wrap {
    Wrap(int x){
//        getClass()
    }
    Wrap() {

    }
    void s(){}

}

class Callee {
      class  dd2 implements dd{
          dd2() {

          }
        public void dg() {

        }

        @Override
        public void s() {

        }
    }

    public dd2 get() {
        return new dd2();
    }

}

class tf extends Callee {
    public void gt() {

    }
}
class InheritInner extends Callee.dd2 {
    InheritInner(Callee x) {
        x.super();
    }
}

public class innerClass {
    @Test
    public dd test(final int j) {
         dd gg=new Callee().get();
        gg.s();
        int  i=1;
        if(i>1)
        // Logger.getGlobal().info("123");
        {
            new Wrap(i){
                void ss(){
                    System.out.println(j);
                }

            };
            class dd1 implements dd {
                @Override
                public void s() {
                    System.out.println(1);
                }


            }
        return new dd1();}
        else {
            class dd1 implements dd {
                @Override
                public void s() {
                    System.out.println(2);
                }
            }
            return new dd1();

        }
    }
    @Test
    public void test2(){

        try(FileInputStream in1=new FileInputStream("")) {

        }  catch (IOException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                System.out.println(element.toString());
            }

        }
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

            }
        });

    }
    public static void main(String[] args) {
        Sequence<Integer> sequence = new Sequence<>(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);

        }
        selector<Integer> selector = sequence.selector();
        Sequence<Integer>.sequenceSelector<Integer> integersequenceSelector = sequence.new sequenceSelector<>();

        System.out.println("");
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
