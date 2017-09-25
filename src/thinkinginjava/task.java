package thinkinginjava;

import org.junit.Test;

import java.util.*;

/**
 * Created by CS on 2017/9/24.
 */
public class task
{

    public static   void show() {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println(reader.read());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String[] split = "(123+345)*12513".split("\\D");
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s);
        }
    }
@Test
    public void hh() {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> sp = new TreeMap<>();
        TreeSet<Integer> st = new TreeSet<>();
        LinkedHashMap<Integer, Integer> lp = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            lp.put(i, i);
        }
        lp.entrySet().forEach(System.out::println);
    }
    public static void main(String[] args) {
//        show();
        AsociationArray<String, String> pair = new AsociationArray<>(5);
        pair.put("1", "1");
        pair.put("2", "2");
        pair.put("3", "3");
        System.out.println(pair.get("1"));
        System.out.println(pair.toString());

    }
//        Path dir = Paths.get("C:\\Users\\CS\\Desktop\\薛峰-2017M62ZJ02422");
//        try (DirectoryStream<Path> paths = Files.newDirectoryStream(dir);) {
//
//            try (BufferedWriter w=Files.newBufferedWriter(dir.resolve("1.txt"),StandardOpenOption.CREATE)){
//                for (Path path : paths) {
//                    String s = path.getFileName().toString();
//                    String s1 = s.substring(0, s.indexOf("."));
//                    System.out.println(s1);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
class AsociationArray<K,V>{
    private Object[][] pairs;
    private int index;

    public AsociationArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if(key.equals(pairs[i][0]))
                return (V)pairs[i][1];
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(pairs);
    }
}

class lru<K,V> {
    class Entry<K, V>{
        private Entry pre;
        private Entry next;
        public K key;
        public V value;
    }
    private final int max;
    private Entry first;
    private Entry last;
    private HashMap<K, Entry<K, V>> map;

    public lru(int max) {
        this.max = max;
        map = new HashMap<K, Entry<K, V>>();
    }

    private Entry<K, V> getEntry(K key) {
        return map.get(key);
    }

    private void removeLast() {
        if (last != null) {
            last=last.pre;
            if (last == null) {
                first=null;
            }
            else last.next=null;
        }
    }

    private void moveToFirst(Entry entry) {
        if (entry == null)  return;
        if(entry.pre!=null) entry.pre.next=entry.next;
        if(entry.next!=null) entry.next.pre=entry.pre;
        if(entry==last) last=last.pre;
        if(first==null||last==null){
            first=last=null;
            return;
        }
        entry.next=first;
        first.pre=entry;
        first=entry;
        entry.pre=null;
    }

    public void remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            if(entry.pre!=null) entry.pre.next=entry.next;
            if(entry.next!=null) entry.next.pre=entry.pre;
            if(entry==first) first=entry.next;
            if(entry==last) last=entry.pre;
        }
        map.remove(key);
    }
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }

}
