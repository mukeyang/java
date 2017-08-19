package thinkinginjava;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by CS on 2017/8/19.
 */
public class unit1 {
    public static void main(String[] args) throws IOException {
        Files.createFile(Paths.get("1.txt"));
        System.getProperties().list(new PrintStream(Files.newOutputStream(Paths.get("1.txt"))));
        Integer[]a=new Integer[]{1,2,3,4};
        System.out.println(a.length);
    }
}
