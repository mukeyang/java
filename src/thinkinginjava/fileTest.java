package thinkinginjava;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.LinkedList;

/**
 * Created by CS on 2017/9/6.
 */
enum  color{
    red,green,blue
}
public class fileTest {
    @Test
    public void nio() {
        try {
            FileChannel channel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
            FileChannel fileChannel = FileChannel.open(Paths.get("3.txt"), StandardOpenOption.WRITE);
//            channel.transferTo(0,channel.size(),fileChannel);
            Files.copy(Paths.get("1.txt"),Paths.get("5.txt"),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void aio() {
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("3.txt"), StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //one
//            Future<Integer> read = fileChannel.read(buffer, 0);
//            while (!read.isDone());
//            buffer.flip();
//            byte[] bytes = new byte[buffer.limit()];
//            buffer.get(bytes);
            //two
            fileChannel.read(buffer, 0,buffer, new CompletionHandler<Integer,ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {

//                     buffer.flip();
                    System.out.println("result = " + result);

                    attachment.flip();
                    byte[] data = new byte[attachment.limit()];
                    attachment.get(data);
                    System.out.println(new String(data));
                    attachment.clear();
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("123");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void ss() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("c:/");
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
            while (true) {
                WatchKey take = watchService.take();
                for (WatchEvent<?> event : take.pollEvents()) {
                    System.out.println(event.context()+""+event.kind());
                }
                if(!take.reset())
                    return;
            }
//            System.out.println(path.getRoot());
        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }
    }
@Test
public void hh(){
    EnumSet<color> range = EnumSet.range(color.red, color.blue);
    range.stream().forEach(System.out::println);
}
    @Test
    public <T>void tf() {
        class dd{
        LinkedList<T> ts = new LinkedList<>();
            public T pop(){
                 return ts.poll();
            }

            public boolean push(T e) {
                return  ts.add(e);
            }


    }}
}
class turple<A,b>{
    public  static <A,b>void tt(A a, b b1) {


    }
}
