package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by CS on 2018/3/12.
 */
public class PatgClasdLoader extends ClassLoader {
    private String classPath;

    public PatgClasdLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = getData(name);
        if (data != null) return defineClass(name, data, 0, data.length);
        return super.findClass(name);
    }

    private byte[] getData(String name) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(name + ".class"));
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
