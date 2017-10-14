package concurrent;

/**
 * Created by CS on 2017/10/14.
 */
public interface ThreadPool<job extends Runnable> {
    void execute(job job);

    void shutdown();

    int size();

    void removeWorker(int num);

    void addworkers(int num);
}
