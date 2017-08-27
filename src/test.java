import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by CS on 2017/8/23.
 */
public class test {
    @Test
    public  void dw () {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(4, 5);
        map.put(2, 2);
        map.put(0,4);
map.descendingMap().entrySet().stream().filter(a->true).peek(a-> System.out.println(a+"gg")).forEach(System.out::println);

    }



}
class  Pair<T extends  Comparable<? super T>>{
    T first;

    public T getFirst() {

        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public Pair() {
       this(null,null);
    }
}

