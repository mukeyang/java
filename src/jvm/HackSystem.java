package jvm;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by CS on 2017/11/14.
 */
public class HackSystem {
    public static final InputStream in = System.in;
    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    public static final PrintStream out = new PrintStream(buffer);
    public static final PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void bufferClear() {
        buffer.reset();
    }

}

class a {
    public int ss(int n) {
        System.out.println("ss");
        return n;
    }
}

class c extends a{

    public  void gg(String args) throws Throwable {
        MethodType type = MethodType.methodType(int.class, int.class);
        MethodHandle ss = MethodHandles.lookup().findVirtual(a.class, "ss", type ).bindTo(new a());
        System.out.println(ss.invokeWithArguments(1));
    }

    @Override
    public int ss(int n)  {
        try {
            MethodType t1=MethodType.methodType(int.class,int.class);
            MethodHandle ss = MethodHandles.lookup().findSpecial(a.class, "ss", t1, getClass());
            ss.invokeWithArguments(1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 1;

    }

    public static void main(String[] args) throws Throwable {
        new c().ss(1);
    }
}
