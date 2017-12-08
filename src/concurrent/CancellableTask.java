package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * Created by CS on 2017/12/8.
 */
public interface CancellableTask<T> extends Callable<T>{
    void cancle();

    RunnableFuture<T> newTask();
}
