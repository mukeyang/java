package concurrent;

/**
 * Created by CS on 2017/12/6.
 */
public class ThreadGroupName implements Runnable {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg,new ThreadGroupName(),"T1");
        Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName());
    }
}
