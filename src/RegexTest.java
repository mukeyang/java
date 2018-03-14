import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CS on 2017/9/28.
 */
public class RegexTest {
    public static void main(String[] args) {
        for (grade grade1 : grade.values()) {
            System.out.println(grade1.ordinal());
            System.out.println(grade1.getClass());
            System.out.println(grade1.getDeclaringClass());
        }
    }
    @Test
    public void gg() {
        String regex = "";
        String str = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

    }

    @Test
    public void h() {
        String g="";
        File file = new File(".");
        file.list((dir, name) -> {
            Pattern df = Pattern.compile(g);
            return false;
        });

        String[] list = file.list((dir, name) -> Pattern.matches("[0-9]\\.txt",name));
        for (String s : list) {
            System.out.println(s);
        }

    }
}

enum grade {
    Y,N

}