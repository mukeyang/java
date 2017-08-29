import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by CS on 2017/8/24.
 */
public class StreamTest {
    public  static Map<Integer,Integer>map=new HashMap<Integer,Integer>(){

        {
            put(1,2);
            put(4,3);
            put(2,4);
            put(5,8);
            put(3,8);
        }
    };
    @Test
    public void sorted() {
        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;

        BinaryOperator<Integer> tBinaryOperator = BinaryOperator.minBy(Comparator.reverseOrder());
        System.out.println(tBinaryOperator.apply(1, 3));
        map.entrySet().stream().forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)).forEach((a,b)-> System.out.println(a+"="+b));
        LinkedHashMap<Integer, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, newvalue) -> old, LinkedHashMap::new));

        Arrays.parallelPrefix(new int[]{1,2,3,4},(a,b)->a+b);
    }
    @Test
    public void timeTest() {
        System.out.println(Instant.now());
        LocalDateTime start = LocalDateTime.now();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime end = LocalDateTime.now();

        System.out.println(Duration.between(start,end).getSeconds());
        map.computeIfAbsent(8,a->9);

    }

    @Test
    public void streamTest() {

        BinaryOperator<Integer> integerBinaryOperator = BinaryOperator.<Integer>minBy(Comparator.naturalOrder());
        Map<Integer, Long> collect = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 8).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map.keySet().stream().reduce(0, (sum, item) -> sum + item));
        Map<Integer, Long> collect1 = map.keySet().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect1.forEach((a,b)-> System.out.println(a+"gg"+b));
        Map<Integer, Set<Integer>> collect2 = map.keySet().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Function.identity(), Collectors.toSet())));
        "chensiayng".chars().mapToObj(Integer::new).sorted((Comparator.<Integer,Integer>comparing(Function.identity()).reversed())).reduce(0,(a,b)->a+b);
    }

    @Test
    public void mapTest() {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        map1.put(2, 2);
        map1.put(3, 3);
        System.out.println(map1.getOrDefault(4, 4));
        map1.forEach((a,b)-> System.out.println(a+""+b));
        map1.replaceAll((key,value)->key*10+value);
        map1.forEach((a,b)-> System.out.println(a+"="+b));
        map1.putIfAbsent(4,4);
        System.out.println(map1.remove(2, 3));
        map1.replace(1, 11, 21);
        map1.computeIfAbsent(5, a -> a * 10);
        System.out.println("get 5"+map1.get(5));
        map1.computeIfPresent(5,(a,b)->a+b);
        map1.merge(5,5,(oldvalue,newvalue)->null);
        System.out.println(map1.getOrDefault(5, 0));


    }
}
