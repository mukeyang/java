package thinkinginjava;

/**
 * Created by CS on 2017/9/1.
 */
public class exception {

    public static  void main(String[] args) {
        Object[] objects = new Object[3];
        for (Object o : objects) {
            o=new Integer(3);
        }
        testList w = (testList) objects[2];
        System.out.printf("[%h,%1$s]",3,"123");

    }

//        try {
//            throw new IOException();
//        }
//        finally {
//            System.out.println("123");
//            //ignore any thrown exception
//            String s = "1314"+"123";
//            return ;
//        }
//    }
}