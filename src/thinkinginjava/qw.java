package thinkinginjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by CS on 2017/8/25.
 */
class Image{
    public String id;
    public ArrayList<String>feature;

    @Override
    public String toString() {
        return id+"\n feature:"+feature.toString();
    }
}
class SImage{

}

public class qw {
    @Test
    public void testLog() throws IOException {
//        Logger test = Logger.getLogger("test");
//        ConsoleHandler console = new ConsoleHandler();
//        console.setLevel(Level.ALL);
//        MemoryHandler mhandle = new MemoryHandler(console,10, Level.ALL);
////        test.addHandler(mhandle);
//        if(Files.notExists(Paths.get("2.txt")))
//        Files.createFile(Paths.get("2.txt"));
//        FileHandler file= new FileHandler("2.txt", true);
//        file.setLevel(Level.ALL);
//        file.setFormatter(new SimpleFormatter());
//        test.addHandler(file);
//        test.setLevel(Level.ALL);
//
//        test.info("123");
        System.out.println(Double.parseDouble("3.123124354657668698"));
    }
    @Test
    public void testRead() {
        char[] a=new char[4096];
        String path = "D:/dataset/features.txt";
        try {
          Files.newBufferedReader(Paths.get(path)).read(a);
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testItr() {
        Gson gson = new Gson();
        Map<Integer, Integer> a = new HashMap<>();
        a.put(1, 2);
        a.put(4, 2);
        a.put(2, 2);
        System.out.println(gson.toJson(a));
    }
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<Collection<Image>>() {

        }.getType();
        System.out.println(Files.newBufferedReader(Paths.get("D:/dataset/features.txt")).lines().limit(2).collect(Collectors.joining("")));
         List<Image> sw = gson.fromJson(Files.newBufferedReader(Paths.get("D:/dataset/features.txt")).lines().limit(10000).collect(Collectors.joining(""))+"]", type);
        System.out.println(sw.size());
        for (int i = 0; i < 30; i++) {
            System.out.println(sw.get(i));
        }




//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        ListIterator<Integer> iterator = a.listIterator();
////        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            System.out.println(iterator.next());
//        System.out.println(iterator.previous());
//        iterator.add(4);
//        System.out.println(iterator.previous());
//
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//
//        System.out.println(iterator.next());
//        a.forEach(System.out::println);
//        }

    }

//    public static void main(String[] args) throws Exception {
//        try (RandomAccessFile r1 = new RandomAccessFile("D:/dataset/image_features_Clothing_Shoes_and_Jewelry.txt", "r")) {
//            FileChannel channel = r1.getChannel();
//            ByteBuffer id = ByteBuffer.allocate(10);
//            ByteBuffer v = ByteBuffer.allocate(4096);
//            v.order(ByteOrder.LITTLE_ENDIAN);
//            ByteBuffer[]s=new ByteBuffer[]{id,v};
//            long read = channel.read(s);
//            System.out.println(read);
//            id.flip();
//            v.flip();
//            while (id.hasRemaining()){
//                System.out.print(((char) id.get()));
//            }
//            while (v.hasRemaining()){
//
//                System.out.println(v.getFloat());
//            }
////            d[]d1=new d[10];
////            Arrays.sort(d1,(a,b)->a.i-b.i);
////            Charset charset = Charset.forName("UTF-8");
////            CharBuffer charBuffer = charset.newDecoder().decode(buffer);
////            System.out.println(charBuffer);
//
//
//        }
//
//
//    }
}