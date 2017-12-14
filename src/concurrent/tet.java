package concurrent;

import org.junit.Test;

/**
 * Created by CS on 2017/12/9.
 */
public class tet {
    static  String s="";
    @Test
    public String m() {

        try {
            return s="a";
        } finally {
            s = "b";
        }
    }

    public static void main(String[] args) {
        System.out.println(new tet().m());
        System.out.println(s);
    }
}
