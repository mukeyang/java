package jvm;

/**
 * Created by CS on 2017/10/12.
 */
public class ThreadState {
    static class TimeWaiting implements Runnable{

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Wating implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Wating.class) {
                    try {
                        Wating.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true)
                    SleepUtils.second(100);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"Time Wating").start();
        new Thread(new Wating(),"Wating").start();
        new Thread(new Blocked(),"blocked-1").start();
        new Thread(new Blocked(),"blocked-2").start();
    }
}
