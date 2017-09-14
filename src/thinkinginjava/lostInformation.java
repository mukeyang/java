package thinkinginjava;

import org.junit.Test;
import org.omg.CORBA.IntHolder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by CS on 2017/9/6.
 */
public class lostInformation<T> {
    ArrayList<Integer> a=new ArrayList<>();
    ArrayList<String> a1=new ArrayList<>();
    @Test
    public void ss()throws Exception {
//        ArrayList<IntHolder> a = new ArrayList<>();
        Map<Integer, IntHolder> b = new HashMap<>();
        System.out.println(Arrays.toString(b.getClass().getTypeParameters()));
        System.out.println("tt");
        System.out.println(((ParameterizedType) getClass().getDeclaredField("a").getGenericType()).getActualTypeArguments()[0]);
        Type type = new base<Map<Integer, Integer>>() {
        }.getClass().getGenericSuperclass();
        System.out.println(((ParameterizedType) type).getActualTypeArguments()[0]);
    }

    @Test
    public void rf() {

//        System.out.println(a.getClass() == a1.getClass());
//        System.out.println(a.getClass().equals(a1.getClass()));
//        Byte[] bytes = {1, 2, 3, 24, 5};
//        Set<Byte> myset=new HashSet<>(Arrays.asList(bytes));

    }


    void hg (Setter s1, Setter s2, Self s3) {
        s1.set(s2);
//        s1.set(s3);
    }

    @Test
    public void  ee() {
        int[] a = {1, 2, 7, 4, 5};
        System.out.println(max(a, 0));
    }

    @Test
    public void ffg() {
        base<Integer>[] bases = (base<Integer>[]) new Object[3];
        base<Integer>[] bases1 =new base[3];
        bases[0]=new base<>();
        Arrays.fill(bases,new base<>());

//        bases[1]=new Object();
    }
    int max(int[] a, int index) {
//        System.out.println(index);
        if(index==a.length-1) return a[index];
        int a1 = a[index];
        int a2=max(a,++index);
        return a1>a2? a1:a2;
    }
}
class base<T>{}

interface Self<T> {
    void set(T arg);
}

interface Setter extends Self<Setter> {

}