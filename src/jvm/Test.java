package jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by CS on 2017/11/20.
 */
public class Test {


    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class,
                        "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        (new Test().new Son()).thinking();
        Arrays.toString(Class.forName("java.util.HashMap").getTypeParameters());
        Type type = new HashSet<String>() {
        }.getClass().getGenericSuperclass();
        ParameterizedType type2 = (ParameterizedType) type;
        Type[] types = type2.getActualTypeArguments();
        Type type1 = ((ParameterizedType) type).getOwnerType();
        System.out.println(type2.getRawType());
        Arrays.stream(types).forEach(System.out::println);
        System.out.println(type instanceof ParameterizedType);
    }
}