package concurrent;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created by CS on 2017/12/8.
 */
public class CallableCancled extends ThreadPoolExecutor {


    public CallableCancled(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if(callable instanceof  CancellableTask) return ((CancellableTask) callable).newTask();
        return super.newTaskFor(callable);
    }
}

abstract class SocketUsingTask<T> implements CancellableTask<T> {
    public Socket socket;

    public SocketUsingTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public synchronized void cancle() {
        try {
            if (socket != null)
            socket.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }

    }

    @Override
    public RunnableFuture<T> newTask() {

        return new FutureTask<T>(this) {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketUsingTask.this.cancle();
                } finally {
                    return super.cancel(mayInterruptIfRunning);

                }
            }
        };
    }

    @Override
    public T call() throws Exception {
        return null;
    }
}