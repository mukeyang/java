package thinkinginjava;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.prefs.Preferences;

/**
 * Created by CS on 2017/10/5.
 */
public class io {
    public String read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(""));) {
            String s;
            StringBuilder builder = new StringBuilder();
            while ((s = reader.readLine()) != null) {
//                System.out.println(s);

            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
@Test
    public void memory() throws Exception {
//        ByteArrayInputStream in = new ByteArrayInputStream(read().getBytes());
        FileChannel open = FileChannel.open(Paths.get("1"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = open.read(buffer);
    System.out.println(read);
    System.out.println(ByteBuffer.allocateDirect(1024).hasArray());
    buffer.putChar('里');
    buffer.flip();
    System.out.println(buffer.hasArray());
    System.out.println(buffer.limit());

//    Charset charset = Charset.forName("utf-8");
//    CharsetDecoder decoder = charset.newDecoder();
//    System.out.println(decoder.decode(buffer));

    CharBuffer buffer1 = buffer.asCharBuffer();
//    while (buffer.hasRemaining())
//        System.out.println((char) buffer.get());
    buffer.position(6);
    System.out.println(buffer.getChar());
    System.out.println(buffer.position());
}

    public void copy() throws Exception {
        FileChannel channel = FileChannel.open(Paths.get(""));
        FileChannel channel1 = FileChannel.open(Paths.get(""));
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        int c;
        System.out.println(buffer.remaining());
        while ((c = channel.read(buffer)) != -1) {
            buffer.flip();
            channel1.write(buffer);
            buffer.compact();
        }
    }
@Test
    public void BufferTotext() throws Exception {
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    FileChannel channel = FileChannel.open(Paths.get("1"), StandardOpenOption.READ, StandardOpenOption.WRITE);
//        channel.write(ByteBuffer.wrap("你好离合".getBytes("utf-8")));
    ByteBuffer put = ByteBuffer.allocate(1024);
    CharBuffer charBuffer = put.asCharBuffer();
    charBuffer.put("你在苏格兰");
//    System.out.println(charBuffer.position());
   charBuffer.flip();
//    System.out.println(put.limit());
    System.out.println(put.limit());
    ByteBuffer slice = put.slice();
    System.out.println("ca"+slice.capacity());
    channel.write(slice);
//    System.out.println(channel.position());
    channel.position(0);
    System.out.println(channel.read(buffer));
    buffer.flip();
    System.out.println(buffer.remaining());
    System.out.println(buffer.asCharBuffer());
}

    @Test
    public void bft() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.asIntBuffer().put(1023);
        buffer.position(4);
        buffer.asIntBuffer().put(1023);
        buffer.putInt(44);
        buffer.rewind();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getInt());
    }
@Test
    public void zip() throws IOException, ClassNotFoundException {
        Path path = Paths.get("1.dat");
        Files.deleteIfExists(path);
        Files.createFile(path);
//        FileSystem fileSystem = FileSystems.newFileSystem(path, null);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toFile()));
        hotpot hotpot = new hotpot();
        hotpot.i=3;
        outputStream.writeObject(hotpot);
        thinkinginjava.hotpot hotpot1 = (hotpot) inputStream.readObject();
        System.out.println(hotpot1.i);

    }
    @Test
    public void hgf() {
        Preferences preferences = Preferences.userNodeForPackage(getClass());
        preferences.put("name", "yang");

    }
    @Test
    public void get() {
        Preferences preferences = Preferences.userNodeForPackage(getClass());
        System.out.println(preferences.get("name", "1"));
    }
}

class hotpot implements Externalizable {
    public int i;
    public hotpot() {
        System.out.println("con");
    }
    @Override

    public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        i = in.readInt();
    }
}
