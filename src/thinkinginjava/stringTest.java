package thinkinginjava;


import org.junit.Test;
import org.omg.CORBA.IntHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CS on 2017/9/2.
 */
public class stringTest {
    @Test
    public void t2() throws CloneNotSupportedException {
        String s = "here are hf";
//        System.out.println(s.replaceFirst("\\w+", "yy"));
        String[] strings = {"abcabcabchdksabc", "abc+", "(abc)+","(abc){2,}"};
        for (String string : strings) {
            System.out.println("regular expression "+string);
            Pattern compile = Pattern.compile(string);
            Matcher matcher = compile.matcher(strings[0]);
           System.out.println(matcher.matches());//entire string
            System.out.println(matcher.lookingAt());//the beginning match

            while (matcher.find()) {
                System.out.println("match\"" + matcher.group() + "  pos" + matcher.start() + "---" + (matcher.end() - 1));
            }

        }
        Scanner scanner = new Scanner(s);
        String patterns = "";
        while (scanner.hasNext(patterns)) {
            scanner.hasNext(patterns);
            MatchResult match = scanner.match();
            System.out.println(match.group(1));
        }

//        testClone();

    }
@Test
    public void st() {
        Map<IntHolder,IntHolder> a=new HashMap<>();
    System.out.println(a.getClass());
    a.put(new IntHolder(1),new IntHolder(1));
        a.put(new IntHolder(4),new IntHolder(4));
        a.put(new IntHolder(4),new IntHolder(4));
        a.put(new IntHolder(9),new IntHolder(9));
        a.put(new IntHolder(3),new IntHolder(3));
        a.keySet().stream().limit(3).forEach(b-> System.out.println(b.value));

    }
    public void testClone() throws CloneNotSupportedException {
        tt a=new tt();
        a.a.value=5;
        tt o =  a.clone();

        System.out.println(o.a.value);
    }
}

class tt implements Cloneable {
    public IntHolder a=new IntHolder(3);

    @Override
    protected tt clone() throws CloneNotSupportedException {
        return (tt)super.clone();
    }

    public void f() {
        System.out.println("345");
    }
}