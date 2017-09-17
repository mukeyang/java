package thinkinginjava;

import java.util.*;

/**
 * Created by CS on 2017/9/17.
 */
public class Amap {
    public static void main(String[] args) {
        System.out.println(new CoungtingList(10));

        System.out.println(new CountingMapData(60));
    }
}

class CoungtingList extends AbstractList<Integer> {
    private int size;

    public CoungtingList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }
}

class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        this.size = size;
    }

    private static class Entry implements Map.Entry<Integer, String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index%chars.length]+Integer.toString(index/chars.length  );
        }

        @Override
        public String setValue(String value) {
            return null;
        }
    }
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        LinkedHashSet<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    }
}