import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by CS on 2017/10/9.
 */
public class tt {
    public static void main(String[] args) {
        Supplier<Stream<Integer>> b1= ()->Stream.iterate(1, a -> a + 1).limit(100);
        new Random().ints(0, 10).limit(10).forEach(System.out::println);
        StringJoiner joiner = new StringJoiner("-","pre,","suf,");
        joiner.add("1");
        joiner.add("1");
        System.out.println(String.join("x", "1", "2"));
        b1.get().sorted(Comparator.<Integer>naturalOrder().reversed()).findFirst().ifPresent(System.out::println);
        IntSummaryStatistics collect = b1.get().collect(Collectors.summarizingInt(a -> (int) a));
        System.out.println(collect.getCount());
        System.out.println(collect.getSum());
        b1.get().collect(ArrayList::new,(list,item)->list.add(item),(list1,list2)->list1.addAll(list2));

    }

}
