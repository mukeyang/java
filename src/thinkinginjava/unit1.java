package thinkinginjava;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by CS on 2017/8/19.
 */
public class unit1 {
    @Test
    public void ss() {
        try {
            Files.walkFileTree(Paths.get("c:/"), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println(dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;

                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;

                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("c:/"))) {
            for (Path path : paths) {
                System.out.println(path);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
//        if(!Files.exists(Paths.get("1.txt")))
//        Files.createFile(Paths.get("1.txt"));
//        System.getProperties().list(new PrintStream(Files.newOutputStream(Paths.get("1.txt"))));
//        Integer[]a=new Integer[]{1,2,3,4};
//        System.out.println(a.length);
//       // printArray(new Integer[]{1,2,3,4},new Integer[]{1,2,3,4});
//        printArray(1,'a');
//       //
//        // printArray('b', 'a');
        ew a=new er();
        System.out.println(a.i);

    }

    static void printArray(Character... args) {
        for (Object arg : args) {
            System.out.println(1);
        }

    }
    static void printArray(long c,Character... args) {
        for (Object arg : args) {
            System.out.println(2);
        }

    }

}

class ew   {

    int i=1;
    void setI(){
        System.out.println("ew"+i);
    }


}

class er extends ew {
    int i=3;

    @Override
    void setI() {
        System.out.println(i);
    }
}

