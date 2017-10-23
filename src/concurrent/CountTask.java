package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by CS on 2017/10/20.
 */
public class CountTask extends RecursiveTask<Integer> {
    public static final int threshold=2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean flag=(end-start)<=threshold;
        if (flag) {
            for (int i = start; i <=end; i++) {
                sum += i;
            }
        } else {
            int middle=(start+end)/2;
            CountTask left = new CountTask(middle + 1, end);
            CountTask right = new CountTask(start, middle);
            left.fork();
            right.fork();
            int lr = left.join();
            int rr = right.join();
            sum=lr+rr;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        ForkJoinTask<Integer> task1 = pool.submit(task);
        try {
            System.out.println(task1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
