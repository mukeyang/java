import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by CS on 2017/8/23.
 */
public class test {
    @Test
    public  void dw () {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(4, 5);
        map.put(2, 2);
        map.put(0,4);
        map.descendingMap().entrySet().stream().filter(a->true).peek(a-> System.out.println(a+"gg")).forEach(System.out::println);
    }
    @Test
    public void sd() throws Exception {
        int count=0;
        Path w = Paths.get("Women.txt");
        Files.deleteIfExists(w);
        BufferedWriter women = Files.newBufferedWriter(w, StandardOpenOption.APPEND,StandardOpenOption.CREATE_NEW);
        Path m = Paths.get("Men.txt");
        Files.deleteIfExists(m);
        BufferedWriter men = Files.newBufferedWriter(m,StandardOpenOption.APPEND,StandardOpenOption.CREATE_NEW);

        HashSet<String> subcat = new HashSet<>();
        subcat.add("Women");
        subcat.add("Men");
        String id="";

        Scanner scanner = new Scanner(new FileReader("C:\\Users\\CS\\Desktop\\productMeta_simple.txt"));
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (!s.startsWith(" ")) {
                id = s.split(" ")[0];
//                System.out.println(id);
            } else {
                String[] split = s.trim().split(",");
//                System.out.println(Arrays.toString(split));
//                System.out.println(Arrays.toString(split));
//                boolean b = ;
//                boolean b1 = ;
//                boolean b2 = !subcat.contains(split[1].trim());
//                System.out.println(b+""+b1+b2);
                if (split.length < 2 || !split[0].equals("Clothing Shoes & Jewelry") || !subcat.contains(split[1].trim()))
                    continue;
//                System.out.println(split[1]+id);
                if (split[1].trim().equals("Women"))
                { women.write(id + "\n");
                System.out.println(++count);}
                else {
                    System.out.println("j");
                    men.write(id + "\n");
                }
            }
        }
        men.close();
        women.close();
    }
@Test
public void pathTest() {
    Path path = Paths.get("c:/hello/hello");
    System.out.println(path.resolve("hello"));
    System.out.println((Paths.get("c:/hello").relativize(path)));

}

    @Test
public  void line() {
    Path path = Paths.get("C:\\Users\\CS\\Documents\\visual studio 2015\\Projects\\ConsoleApplication5\\ConsoleApplication5\\reviews_Men.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
        Set<String> set = reader.lines().map(a -> a.split(",")[1]).collect(Collectors.toSet());

        System.out.println(set.size());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Test
    public void y() {
        Set<String> cat=null;
        Set<String> rt=null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\CS\\IdeaProjects\\java8\\Men.txt"));) {
           cat = reader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader rt1 = Files.newBufferedReader(Paths.get("D:\\Yang1\\ratings.csv"))) {
            rt = rt1.lines().map(a -> a.split(",")[1]).collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        rt.retainAll(cat);
        System.out.println(rt.size());
    }

}
class  Pair<T extends  Comparable<? super T>>{
    T first;

    public T getFirst() {

        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public Pair() {
       this(null,null);
    }
}

