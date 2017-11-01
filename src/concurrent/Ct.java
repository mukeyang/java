package concurrent;


import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/10/29.
 */
public class Ct {
   int i=3;
    private String donwloadSites() {
return null;
    }
    public static void main(String[] args) throws IOException, InterruptedException {

//        Future<Integer> submit = Executors.newFixedThreadPool(2).submit(() -> 3/0 );
        ThreadPoolExecutor executor=new ThreadPoolExecutor(2,2,0,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("prepare"+r.toString());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("after"+r.toString());

            }

            @Override
            protected void terminated() {
                super.terminated();
            }
        };
        Future<Integer> submit = executor.submit(() -> 3 / 0);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(submit.isDone());
//        URLConnection url = new URL("http://www.baidu.com").openConnection();
//        url.connect();
//        new BufferedReader(new InputStreamReader(url.getInputStream())).lines().forEach(System.out::println);
    }
//        CompletableFuture.supplyAsync(() -> {
//            URLConnection a=null;
//
//            try {
//               a= new URL("http://www.baidu.com").openConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return a;
//        }).thenAcceptAsync(a -> {
//            try {
//                a.connect();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//    }
}
