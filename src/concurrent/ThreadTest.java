package concurrent;

/**
 * Created by CS on 2017/12/17.
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread.currentThread().getThreadGroup().list();
    }
}
