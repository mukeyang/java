package jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by CS on 2017/11/9.
 */
public class MethodHandleTest {
    static class A{
        public void println(String s) {
            System.out.println("A"+s);
        }
    }

    static class B extends A {
        @Override
        public void println(String s) {
            super.println("B"+s);
        }
    }

    static class C extends B {
        @Override
        public void println(String s) {
//            super.println("C"+s);
            try {
                MethodType type = MethodType.methodType(void.class,String.class);
                MethodHandle handle = MethodHandles.lookup().findVirtual(A.class, "println", type).bindTo(new A());
                handle.invokeExact("yang");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
    public static MethodHandle getPrintln(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType type = MethodType.methodType(void.class, String.class);
        MethodHandle println = MethodHandles.lookup().findVirtual(receiver.getClass(), "println", type).bindTo(receiver);
        return MethodHandles.lookup().findVirtual(receiver.getClass(),"println",type).bindTo(receiver);

    }
    public static void main(String[] args) throws Throwable {
//        for (int i = 0; i < 3; i++) {
//            Object obj=System.currentTimeMillis()%2==0? System.out:new A();
//            getPrintln(obj).invokeExact("yang");
//
//        }
new C().println("123");
    }
}
