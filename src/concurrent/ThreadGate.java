package concurrent;

/**
 * Created by CS on 2017/12/14.
 */
public class ThreadGate {
    private boolean isOpen;
    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }

    public synchronized void await() throws InterruptedException {
        int arrivalGeneration = generation;
        //防止open之后很快close 导致线程继续wait
        while (!isOpen && arrivalGeneration == generation) {
            wait();
        }
    }
}
