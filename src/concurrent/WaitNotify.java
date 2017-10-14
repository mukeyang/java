package concurrent;

import jvm.SleepUtils;

/**
 * Created by CS on 2017/10/13.
 */
public class WaitNotify {
    static boolean flag=true;
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Wait(),"wait").start();
        new Thread(new NOtiofy(),"wait1").start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
//                        DateTimeFormatter.of
                        System.out.println("flag true");
//                        System.out.println(LocalTime.now());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("flag false");
            }
        }
    }

    static class NOtiofy implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify");
                lock.notifyAll();
                flag=false;
                SleepUtils.second(5);

            }
            synchronized (lock) {
                System.out.println("again");
                SleepUtils.second(5);
            }
        }
    }

}
