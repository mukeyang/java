import java.util.EnumMap;
import java.util.Random;

/**
 * Created by CS on 2017/9/28.
 */
interface command {
    void action();
}
public enum G {
    A(1),B(2),C(3);


    G(int i) {
        this.i = i;
    }

    public int i;
    public  int j=2;
    public static void main(String[] args) {
        try {
            System.out.println(new s().clone().getClass());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (G g : values()) {
            System.out.println(g);
        }
    }

    public void show() {
        System.out.println(i);
    }
}

class s implements  Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        EnumMap<G, command> em = new EnumMap<>(G.class);
        em.put(G.A, () -> {

        });
        em.keySet().forEach(System.out::println);
//        EnumSet.allOf(G.class).forEach(System.out::println);
//        for (G g : G.class.getEnumConstants()) {
//            System.out.println(g);
//        }
        G a=G.A;
        System.out.println(a.j);
//        switch (a) {
//            case  A: return;
//            case  B: break;
//        }
    }
}

interface food {
    enum Main implements food {
        SOUP, SALAD,
    }

    enum coffee implements food {
        black_coffee,Tea;
    }

}

class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T randomc(Class<T> ec) {
        return  random(ec.getEnumConstants());
    }

    private static <T> T random(T[] enumConstants) {
        return enumConstants[rand.nextInt(enumConstants.length)];
    }
}