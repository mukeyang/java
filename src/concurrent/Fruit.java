package concurrent;

/**
 * Created by CS on 2017/10/13.
 */
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public enum Fruit {
    APPLE, BANANA, UNKNOWN;
    private static final Map<String, Fruit> FRUITS_BY_NAME = new ConcurrentHashMap<>();
    static {
        Arrays.stream(Fruit.values()).parallel().forEach(t -> {
            FRUITS_BY_NAME.put(t.name(), t);
        });
    }

    public static void main(String[] args) {
        System.out.println(Fruit.APPLE);
    }
}
