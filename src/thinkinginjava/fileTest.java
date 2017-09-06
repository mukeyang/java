package thinkinginjava;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;

/**
 * Created by CS on 2017/9/6.
 */
public class fileTest {
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
