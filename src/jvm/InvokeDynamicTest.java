package jvm;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by CS on 2017/11/10.
 */
public class InvokeDynamicTest {
    public static void main(String[] args) {

    }

    public static void testMethod(String s) {
        System.out.println("hello" + s);
    }

    public static CallSite BootsrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

//    private static MethodType MT_BootstrapMethod() {
////
//   }
}
