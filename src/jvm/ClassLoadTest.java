package jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by CS on 2017/11/5.
 */
public class ClassLoadTest {
    static {
        System.out.println("hh.sout");
    }

    @org.junit.Test
    public void t() {
        System.out.println(getClass().getResource("Comp.class").getFile().getBytes().length);
    }

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
//                    Class<?>aclass = findLoadedClass(name);
//                    if (aclass != null) {
//                        System.out.println("loaded");
//                        return aclass;
//                    }
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println(getClass().getResource(""));
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
                return null;

            }
        };
        Class<?> aClass = Class.forName("jvm.TestClass", false, ClassLoader.getSystemClassLoader());
        System.out.println(aClass.getClassLoader());
//        URLClassLoader loader = new URLClassLoader(new URL[]{new URL("file:C:\\Users\\CS\\Desktop\\")});
//        Class<?> message = loader.loadClass("Message");
//        System.out.println(message);
//        Object o = myLoader.loadClass("jvm.ClassLoadTest").newInstance();
////        Object o2 = myLoader.loadClass("jvm.ClassLoadTest").newInstance(); //Java.lang.LinkageError
//        System.out.println(o.getClass().getClassLoader());
//        System.out.println(o.getClass());
//        System.out.println(o instanceof jvm.ClassLoadTest);

    }
}
