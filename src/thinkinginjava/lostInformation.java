package thinkinginjava;

import org.junit.Test;
import org.omg.CORBA.IntHolder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CS on 2017/9/6.
 */
public class lostInformation<T> {
    ArrayList<Integer> a=new ArrayList<>();

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

}
class base<T>{}
