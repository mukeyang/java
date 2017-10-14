package concurrent;

import jvm.SleepUtils;

/**
 * Created by CS on 2017/10/13.
 */
public class Join {
    static class Domino implements Runnable {
        private Thread previous;

        public Domino(Thread previous) {
            this.previous = previous;
        }

        @Override
        public void run() {
            try {
                previous.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread pre = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(pre), i + "");
            thread.start();
            pre=thread;
        }
        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName());

    }
}
