package df;

import org.omg.CORBA.IntHolder;

import java.util.ArrayList;

/**
 * Created by CS on 2017/10/10.
 */
public class order {
    public static IntHolder i=null;
    static {
        ArrayList<IntHolder> holders = new ArrayList<>();
        holders.add(i);
        i=new IntHolder(3);
        System.out.println(holders.get(0));
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("df.f");
    }
}

enum f {
    A{{
        System.out.println("rr");
    }},B;
    static {
        System.out.println("gg");
    }
}
