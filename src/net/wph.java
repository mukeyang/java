package net;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by CS on 2017/9/16.
 */
public class wph {
    public static void main(String[] args) {
        Random random=new Random();
        System.out.println(random.ints(1, 10).limit(10).findFirst().getAsInt());
        Optional<String> s1 = Optional.ofNullable("abvc");
        System.out.println(s1.map(String::toUpperCase));
        List<Person> persons = Arrays.asList(new Person("1", 1), new Person("2", 2),new Person("1", 1));
        String s = persons.stream().filter(a -> a.getName().equals("1")).findFirst().map(Person::getName).orElse("");
        Map<Integer, Long> collect = persons.stream().collect(Collectors.groupingBy(a->a.getAge(), Collectors.counting()));
        Map<Integer, Long> collect1 = persons.stream().collect(Collectors.groupingBy(a->a.getAge(), Collectors.summingLong(a->a.getAge())));
        Map<Integer, List<String>> collect2 = persons.stream().collect(Collectors.groupingBy(a -> a.getAge(), Collectors.mapping(a -> a.getName(), Collectors.toList())));
        collect.entrySet().stream().sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()).forEachOrdered(System.out::println);
    }
}
class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //gettersm setters, toString
}