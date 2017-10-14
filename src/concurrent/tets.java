package concurrent;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by CS on 2017/10/12.
 */
class dd {
    int i=3;
    public static final ConcurrentHashMap<Integer, Integer> a = new ConcurrentHashMap<>();
    static {
        a.values().stream().parallel().forEach(System.out::println);
    }

    public static void main(String[] args) {
        dd dd=new dd();
        System.out.println(123);
    }
}


public class tets extends dd implements Serializable {
    int i=4;
    public static void main(String[] args) {
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        ObjectOutputStream stream1 = new ObjectOutputStream(stream);
//        tets dd = new tets();
//        stream1.writeObject(dd);
//        byte[] bytes = stream.toByteArray();
//        stream1.close();
//        ObjectInputStream stream2 = new ObjectInputStream(new ByteArrayInputStream(bytes));
//        concurrent.dd dd1 = (dd) stream2.readObject();
//        System.out.println(((dd) dd1).i);
//        Scanner scanner = new Scanner("3" +"\n"
//                +"1 2 3 4");
//        ArrayDeque<Integer> objects = new ArrayDeque<>();
//        objects.add(1);
//        objects.add(2);
//        objects.poll();
//        objects.forEach(System.out::println);
//        scanner.useDelimiter("[, \n]");
//        while (scanner.hasNext())
//        System.out.println(scanner.nextInt());

    }
}

