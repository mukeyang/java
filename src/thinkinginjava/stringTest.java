package thinkinginjava;

import org.junit.Test;
import org.omg.CORBA.IntHolder;

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
            while (matcher.find()) {
                System.out.println("match\"" + matcher.group() + "  pos" + matcher.start() + "---" + (matcher.end() - 1));
            }

        }
//        testClone();

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