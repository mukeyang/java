

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by CS on 2017/8/17.
 */
public class lambdaTest {
    @FunctionalInterface
    interface Predicate<T
            > {
        boolean test(T t);

        static String name() {
            return "i am cs";
        }
    }

    public void optiontest(user user) {
        Optional<user> user1 = Optional.ofNullable(user);
        Optional<String> s = user1.map(a->a.name);
        System.out.println(s.orElse("no"));

    }
    @Test
    public  void timeTest(){
        System.out.println(LocalDateTime.now());
        LocalDate date = LocalDate.of(2017, 8, 30);
        LocalDate date1 = date.plusDays(1);
        System.out.println(ChronoUnit.DAYS.between(date,date1));
        System.out.println(LocalDate.now().minus(1, ChronoUnit.MONTHS).getDayOfWeek().ordinal()+1);
        System.out.println(LocalDate.now().isLeapYear());
        LocalTime now = LocalTime.now();
        System.out.println(LocalTime.parse("14:23").minus(1, ChronoUnit.HOURS));
        LocalDateTime time = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    public  static void amptest(){
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
    }

    public static void streamTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("CS");
        list.add("DF");
        List<String> list1 = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> list2 = list.stream().map(String::toLowerCase).collect(()->new ArrayList<String>(),(list3,item)->list3.add(item),(l1,l2)-> l1.addAll(l2));
        String a = list.stream().map(String::toLowerCase).reduce("",(sum,item)->sum+item);
        list1.forEach(System.out::println);
        Stream.generate(() -> Math.random()).limit(10).max(Comparator.comparingDouble(x->x)).ifPresent(System.out::println);
        Arrays.asList(1, 2, 3, null, 6, 6, null, 23).stream().filter(Objects::nonNull).distinct().mapToInt(a1 -> a1 * 2).skip(2).sorted().forEach(System.out::println);
    }

    public static boolean dopredict(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = lambdaTest.class.getMethod("main", String[].class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println(parameter.getName());

        }
        boolean isAdult = dopredict(20, x -> x >= 18);
        System.out.println(isAdult);
        List<Integer> list = Arrays.asList(1, 2, 7, 4);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        //streamTest();
//        timeTest();
        amptest();
    }

}

class Value<T> {
    public static <T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }
}
class  user{

    public user(String name, String age) {
        this.name = name;
        this.age = age;
    }

    String name;
    String age;
    public String getName(user user) {
        return user.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }




}
