package thinkinginjava;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CS on 2017/9/7.
 */
public class ArrayMaker<T> {
    Class<T> kind;
    List<T> a=new ArrayList<T>();
//    public ArrayMaker(Class<T> kind) {
//        this.kind = kind;
//    }
public ArrayMaker(){}
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        Type type = ((ParameterizedType) new base<ArrayMaker<Integer>>() {
        }.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type);
        T[] ts = (T[]) Array.newInstance(kind, size);
        return ts;
    }

    void create() {
        Object o = Array.newInstance(kind, 10);
        System.out.println("create"+o.getClass());
    }

    public static void main(String[] args) {
//        System.out.println(new ArrayMaker<Integer>().create(10)[0]);
        ArrayMaker<String> maker = new ArrayMaker<>();
        maker.kind=String.class;
        String[] timo = maker.create(10);
        maker.create();
        System.out.println(timo.getClass());
        System.out.println(maker.getClass().getSimpleName());
        timo[0]="123";
        System.out.println(timo[0]);
        System.out.println("123" instanceof Object);
        System.out.println("123".getClass().isAssignableFrom(new Object().getClass()));
    }

    @Test
    @SuppressWarnings("uncheked")
    public void ty() {
        ArrayMaker<Integer>[]a=(ArrayMaker<Integer>[])new ArrayMaker[10];
        ArrayMaker<Integer>[]a1=(ArrayMaker<Integer>[])new ArrayMaker<?>[10];

        a[0]=new ArrayMaker<>();
//        a[1]=new ArrayMaker<String>();
        a[0].create(10);
    }

    @Test
    public void sd() {
        Class<de2> aClass = de2.class;
        System.out.println(de.i);
        System.out.println("123");
        try {
            de de = aClass.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testS() {
        genericArray<Integer>a=new genericArray<>(2);
        Integer[] ints = new Integer[2];
        a.put(0, 1);
        a.put(1,2);
        for (Object o : a.toArray()) {
            System.out.println((o.getClass()));
//            System.out.println(o);
        }
        for (Integer integer : a.toArray(ints)) {
            System.out.println(integer);
        }
    }

    @Test
    public void sf() {
//        Object[]a =new String[10];
//        a[0]="123";
//        a[1]=2;
//        Object[] objects = Arrays.asList("12", "45").toArray();
//        for (Object object : objects) {
//            System.out.println(object);
//        }
        ArrayList<?super de2>d=new ArrayList<de>();
        ArrayList<? extends de>d2=new ArrayList<de2>();
        d.add(new de2());
        d2.contains(new de());
        ArrayList<? extends Object> d3=new ArrayList<de>();
        Object o = d3.get(1);
    }
}

class de {
    public static final int i=1;
    static {
        System.out.println("de");
    }

    private void s() {
        System.out.println("de1");
    }
}

class de2 extends de {
    public void s() {
        System.out.println("de2");

    }

}

class genericArray<T> {
    private Object[] array;

   public genericArray(int size) {
        array = new Object[size];
   }

    public void put(int dex,T item) {
        array[dex] = item;
    }
@SuppressWarnings("unchecked")
    public T get(int index) {
        return ((T) array[index]);
    }


    public Object[] toArray() {
        return copyOf(array, array.length,array.getClass());
    }

//    public T[] array() {
//
//    }
    public T[] toArray(T[]a) {
        if (a.length < array.length)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(array, array.length, a.getClass());
        System.arraycopy(array, 0, a, 0, array.length);
        if (a.length > array.length)
            a[array.length] = null;
        return a;
    }
    @SuppressWarnings("unchecked")
    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        System.out.println(newType);
        T[]copy=((Object)newType == (Object) Object[].class)?
                (T[])new Object[newLength]:(T[])Array.newInstance(newType.getComponentType(),newLength);
        System.arraycopy(original,0,copy,0,Math.min(newLength,original.length));
        return  copy;
    }
}