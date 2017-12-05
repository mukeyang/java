package jvm;

/**
 * Created by CS on 2017/11/27.
 */

/**
 * test virtual methods distribution
 */
public class TestSf {
    public static void main(String[] args) {
        new Person().P();
        new student().P();
    }
}
class Person{
    Person() {
        System.out.println("1"+info());
    }
    public String info() {
        return "Person";
    }

    public void P() {
        System.out.println(info());

    }
}

class student extends Person {
    student() {
        System.out.println("2"+info());
    }

    public String info() {
        return "student";
    }
}