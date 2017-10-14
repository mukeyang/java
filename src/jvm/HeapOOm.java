package jvm;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS on 2017/10/9.
 */
public class HeapOOm {
    static class OOMobject {
    }

    public static void main(String[] args) {
        List<OOMobject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMobject());
        }
    }

    @Test
    public void run() {
        JVMStack stack = new JVMStack();
        try {
            stack.stackLeak();
        } catch (Exception e) {
            System.out.println(stack.length);
            e.printStackTrace();
        }
    }

}

class JVMStack {
      int length=1;

    public void stackLeak() {
        length++;
        stackLeak();
    }
}

class directMmeoryOOM {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        unsafe.allocateMemory(_1MB);
    }
}