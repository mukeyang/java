package thinkinginjava;

import org.junit.Test;

import java.util.*;

/**
 * Created by CS on 2017/9/15.
 */
public class container {
    @Test
    public void dd() {
        System.out.println(fib(1,0,5));
//        List<Integer> list = Collections.nCopies(4, 3);
//        list.add(3);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        ListIterator<Integer> iterator = list.listIterator(0);
//        System.out.println(iterator.next());
        iterator.add(0);
        System.out.println(iterator.next());
        list.forEach(System.out::println);


    }

    @Test
    public void ts() {
        SetTest.test(new HashSet<SetType>(),SetType.class);
        SetTest.test(new HashSet<HashType>(),HashType.class);
        HashSet<gg> a = new HashSet<>();
        gg e = new gg(1);
        a.add(e);
        gg e1 = new gg(2);
        a.add(e1);
        System.out.println(a);
        System.out.println(e.hashCode()+""+e1.hashCode());
    }

    public double power(double m, int n) {
        if(n==0) return 1;
        else if((n&1)==1) return m * power(m, n - 1);
        else {
            double t = power(m, n - 2);
            return t*t;
        }
    }

    public int fib(int a, int b, int n) {
        if(n==0)
            return b;
        else
            return fib(a + b, a, n - 1);
    }
}

class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i==((SetType) obj).i);
    }

    @Override
    public String toString() {
        return i+"";
    }
}

class gg implements Comparable<gg>{
    int i;

    @Override
    public String toString() {
        return "gg{" +
                "i=" + i +
                '}';
    }

    public gg(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return i/3;
    }

    @Override
    public int compareTo(gg o) {
        return i>o.i? 1:(i==o.i?0:-1);
    }
}
class HashType extends SetType{

    public HashType(int i) {
        super(i);
    }


    @Override
    public int hashCode() {
        return i;
    }
}

class SetTest {
    static <T> Set<T> fill(Set<T> set,Class<T> type) {
        for (int i = 0; i < 10; i++) {
            try {
                set.add(type.getConstructor(int.class).newInstance(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        for (int i = 0; i < 3; i++) {
            fill(set, type);
        }
        System.out.println(set);
    }
}



