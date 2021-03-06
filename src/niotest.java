import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by CS on 2017/8/18.
 */
public class niotest {
    public static void bytetest() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        buffer.put((byte) 1).put((byte)2);
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.mark().position(1).reset().position());
        char[]charBuffer=new char[]{'1','2','3'};
        System.out.println(CharBuffer.wrap(charBuffer).hasArray());
    }

    public static void main(String[] args) {
        Enum.valueOf(Grade.class,"A");
        System.out.println(Grade.values());
        bytetest();
    }

    public static void reflectionTest(String name) {
        try {
            Class<?> c1 = Class.forName(name);
            Class<?> superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers+"");
            }
            System.out.print("class"+name);
            if (superc1 != null && superc1 != Object.class) {
                System.out.println("extends" + superc1.getName());
            }
            System.out.print("\n{\n");
            printConstructor(c1);
            printMethod(c1);
            printField(c1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Object copyof(Object s, int newLength) {
        Class<?> c1 = s.getClass();
        if(!c1.isArray()) return null;
        Class<?> componentType = c1.getComponentType();
        int length = Array.getLength(s);
        Object instance = Array.newInstance(componentType, newLength);
        System.arraycopy(s,0,instance,0,Math.min(length,newLength));
        return instance;
    }
    private static void printField(Class<?> c1) {
        //Todo
    }

    private static void printMethod(Class<?> c1) {
        //Todo
    }

    private static void printConstructor(Class<?> c1) {
        Constructor<?>[] constructors = c1.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            String name = constructor.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers+"");
            }
            System.out.print(name + "(");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getName());

            }
        }

    }

    public static void catFile(String file) throws Exception {
        WritableByteChannel target = Channels.newChannel(System.out);
        FileInputStream stream = new FileInputStream("1.txt");
        FileChannel channel = stream.getChannel();
        channel.transferTo(0,channel.size(),target);
        channel.close();
        stream.close();


    }
}
enum Grade{
    A("100-90"){
        @Override
        public String localvalue() {
            return "you";
        }
    },B("89-80"){
        @Override
        public String localvalue() {
            return "liang";
        }
    };
    private String value;
     Grade(String value){
        this.value=value;
    }
    public  abstract String localvalue();

}
class d1{
     void s(){}

}

class d2 extends d1 {


    @Override
    public  void s() {
        super.s();
    }
}

class chanelCopy {
    public static void main(String[] args) throws IOException {
        ReadableByteChannel channel1 = Channels.newChannel(System.in);
        WritableByteChannel channel2 = Channels.newChannel(System.out);
        //channelCopy1(channel1, channel2);
        testPosition();
    }

    private static void channelCopy1(ReadableByteChannel channel1, WritableByteChannel channel2) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (channel1.read(buffer)!=-1){
            buffer.flip();
            channel2.write(buffer);
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining()){
            channel2.write(buffer);
        }
    }
    private static void channelCopy2(ReadableByteChannel channel1, WritableByteChannel channel2) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (channel1.read(buffer)!=-1){
            buffer.flip();
            while (buffer.hasRemaining()){
                channel2.write(buffer);
            }
        }
        buffer.clear();
    }

    public static void testPosition() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt","r")) {
            randomAccessFile.seek(3);
            FileChannel channel = randomAccessFile.getChannel();
            System.out.println(channel.position());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

