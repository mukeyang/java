package jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by CS on 2017/11/5.
 */
public class ClassLoadTest {
@org.junit.Test
    public void t() {
       System.out.println(getClass().getResource("Comp.class").getFile().getBytes().length);
   }
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
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
        Object o = myLoader.loadClass("jvm.ClassLoadTest").newInstance();
        System.out.println(o.getClass().getClassLoader());
        System.out.println(o.getClass());
        System.out.println(o instanceof jvm.ClassLoadTest);

    }
}
