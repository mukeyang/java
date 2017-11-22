package jvm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by CS on 2017/11/7.
 */
public class ThreadLocakDemo_Gc {
    static volatile ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"){
                @Override
                protected void finalize() throws Throwable {
                    System.out.println(toString()+"GC");
                }
            };
//            return super.initialValue();
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println(toString()+"is GC");
        }
    };
    static volatile CountDownLatch cd = new CountDownLatch(10000);

    static class ParseData implements Runnable {
        int i=0;

        public ParseData(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId() + "create simpleddataFormat");
            try {
                Date date = t1.get().parse("2015-03-29 19:29" + i % 60);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            finally {
                cd.countDown();
            }
        }
    }
}
