package thinkinginjava;

import org.junit.Test;
import org.omg.CORBA.IntHolder;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * Created by CS on 2017/9/1.
 */
public class exception extends testList {
    @Test
    public void sf() {
        Pattern compile = Pattern.compile("\\w+\\.");
        System.out.println(compile.matcher("ewfdsgg.twt ewt").replaceAll(""));
//        if(matcher.find())
//        System.out.println(matcher.group());
        Method[] methods = getClass().getMethods();
        Arrays.stream(getClass().getConstructors()).forEach(System.out::println);
        for (int i = 0; i < methods.length; i++) {
            System.out.println(compile.matcher(methods[i].toString()).replaceAll(""));
        }
//        while (matcher.find()) {
//
//        }
    }
    @Test
    public void teir1() {
//        int[] a = new int[]{9, 12, 2, 11, 2, 2, 10, 9, 12, 10, 9, 11, 2};
//        int i=0;
//        int x = a[0];
//        for (int i1 = 1; i1 < a.length; i1++) {
//            x=x^a[i];
//        }
//        System.out.println(x);
        Class<? extends exception> aClass1 = getClass();
        System.out.println("qwer"+this.getClass().isAssignableFrom(testList.class));
        if (this instanceof testList) {
            System.out.println(1121);
        }
        System.out.println(getClass().isInstance(new exception()));
        int [][]a={{1},{1,2}};
        System.out.println(a[0]);
        for (byte b : ByteBuffer.allocate(4).putInt(1695609641).array()) {
            System.out.format("0x%x \t",b);
        }
        System.out.println(Integer.toBinaryString(14));
    }

    @Test
    public void toarrayTest () throws IllegalAccessException, InstantiationException {
        ArrayList<IntHolder> a =new ArrayList<>();
        a.add(new IntHolder(2));
        a.add(new IntHolder(4));
        a.add(new IntHolder(5));
        a.add(new IntHolder(1));
        a.stream().sorted(Comparator.comparingInt(a1->a1.value)).forEach(System.out::println);
        Class<? extends exception> aClass = getClass();
        Class<? > superclass = aClass.getSuperclass();
        System.out.println(superclass.newInstance().getClass());
        Object[] array = a.toArray();
        for (Object o : array) {
            System.out.println(o.getClass());
        }

    }

    @Test
    public  void testType() {
        int arr1[] = { 0, 1, 2, 3, 4, 5 };
        int arr2[] = { 5, 10, 20, 30, 40, 50 };

        // copies an array from the specified source array
        System.arraycopy(arr1, 0, arr2, 0, 6);
        for (int i : arr2) {
            System.out.println(i);
        }

        Object[] objects = new Object[3];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new IntHolder(1);
            System.out.println(objects[i].getClass());
        }
        for (Object o : objects) {
            System.out.println(o);
        }
        Object[] objects1 = new Object[3];
        IntHolder[] holders = Arrays.copyOf(objects, 3, IntHolder[].class);
        System.arraycopy(objects,0,objects1,0,2);
        for (IntHolder holder : holders) {
            System.out.println(holder);
        }
        for (Object o : objects1) {
            System.out.println(o);
        }
    }
    public static  void main(String[] args) {
        Object[] objects = new Object[3];
        for (Object o : objects) {
            o=new Integer(3);
        }
        testList w = (testList) objects[2];
        System.out.printf("[%h,%1$s]",3,"123");

    }

//        try {
//            throw new IOException();
//        }
//        finally {
//            System.out.println("123");
//            //ignore any thrown exception
//            String s = "1314"+"123";
//            return ;
//        }
//    }
}