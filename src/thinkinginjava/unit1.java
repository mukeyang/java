package thinkinginjava;

import java.io.IOException;

/**
 * Created by CS on 2017/8/19.
 */
public class unit1 {
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

