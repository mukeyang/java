package thinkinginjava;

import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

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
@Test
    public void dd() {
    System.out.println(Arrays.toString(new base<ArrayMaker<Integer>>() {
    }.getClass().getTypeParameters()));
    gg gg = new gg(1);
//    de gg1 = (de) new Object();
//    System.out.println(type);
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
//        System.out.println(de);
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
    public void ggq
            () {
        gg[] ggs = (gg[]) new Object[3];
//        ggs[0]= (gg) new Object();
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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        ArrayList l2=list;
        ArrayList<? extends Object> d8=l2;
//        d8.add(3);
//        gebn(d8);
        ArrayList<String> l21 =  l2;
        System.out.println("test"+l21.get(0));
        ArrayList<de> des = new ArrayList<>();
        ArrayList<?super de2>d= des;
        ArrayList<? extends de>d2=new ArrayList<de2>();
        d.add(new de2());
        Object object = d.get(0);
        System.out.println(des.get(0).getClass());
        System.out.println("des.size="+des.size());
        System.out.println("d.size="+d.size());
        d2.contains(new de());
        ArrayList<? extends Object> d3=new ArrayList<de>();
//        Object o = d3.get(1);
    }

    @Test
    public void testA() {
        ArrayList<String>[] a = new ArrayList[3];
        a[1] = new ArrayList<>();
        ArrayList<String> s = a[1];
        s.add("123");
        System.out.println(s.get(0));
    }
    @Test
    public void hg() {
        System.out.println(new ArrayList<Integer>().getClass());
        ArrayList strings = new ArrayList<>();

        ArrayList<Integer>a=  strings;
        int i =6;
        holder a2=new holder();
        System.out.println(genric(a2, 6));
        try {
            ObjectInputStream stream = new ObjectInputStream(System.in);
            Object o = stream.readObject();

            List<Integer> cast = List.class.cast(o);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
void raw(holder holder,Object arg) {
    holder<Integer> d=holder;
    holder.setT1(arg);

}

    @Test
    public void testList() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        ListIterator<Integer> integerListIterator = a.listIterator();
        integerListIterator.next();
        integerListIterator.next();
        integerListIterator.next();
        System.out.println(integerListIterator.previous());
        integerListIterator.remove();
//        integerListIterator.remove();
        a.forEach(System.out::println);
    }
    void gebn(holder<T> a) {

    }
<T>T genric(holder<T> a,T b) {
    a.setT1(b);
return a.getT1();
}

    void unbound(holder<?> holder,Object arg) {
//        holder.setT1(arg);
        Object t1 = holder.getT1();
    }
    @Test
    public void ff() {
        holder holder = new holder();
        raw(holder,new Object());
        Object t1 = holder.getT1();
    }
}
class holder<T>{
        public T t1;

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }
}

class de {
    public   int i=1;
    static {
        System.out.println("de");
    }

    private void s() {
        System.out.println("de1");
    }
}

class de2 extends de {
    public int i=2;
    public void s() {
        System.out.println("de2");

    }

}

class genericArray<T> {
    private Object[] array;
    private  T[] at;
   public genericArray(int size) {
        array = new Object[size];
//       at=(T[])new Object[size];
//       Object[] objects = new Object[10];
//       gg[] objects1 = (gg[]) objects;
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