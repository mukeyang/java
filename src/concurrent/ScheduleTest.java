package concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * Created by CS on 2017/10/23.
 */
public class ScheduleTest {
    public static void main(String[] args) {
//        new ScheduledThreadPoolExecutor()
    }

    @Test
    public void completion() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService(pool);
        service.submit(() -> 3);
        System.out.println(service.take());
    }

    public void renderImage(ImageInfo.Image a) {

    }

    public void renderPage() {
        ArrayList<ImageInfo> info = new ArrayList<>();
        info.forEach(iamgeInfo -> CompletableFuture.supplyAsync(iamgeInfo::download).thenAccept(this::renderImage));
        Function<ImageInfo, ImageInfo.Image>i2d=a->{
            CompletableFuture<ImageInfo.Image>image=CompletableFuture.supplyAsync(a::download);
            try {
                return image.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            return new ImageInfo.Image();
        };
        info.forEach(a->CompletableFuture.runAsync(()->renderImage(i2d.apply(a))));
        CompletableFuture[] array = info.stream().map(ii -> CompletableFuture.runAsync(() -> renderImage(i2d.apply(ii)))).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(array).join();
        System.out.println("finish");


    }
}

class ImageInfo {
    static class Image {
    }

    Image download() {
        return new Image();
    }
}