package concurrent;

import org.junit.Test;
import org.omg.CORBA.IntHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by CS on 2017/10/21.
 */
public class test {
    static class user {
        volatile int i;
    }
    static IntHolder holder = new IntHolder(3);

    public static void main(String[] args) {
        int[] value = {1, 2, 3, 4};
        AtomicIntegerArray array = new AtomicIntegerArray(value);
        array.getAndSet(0, 3);
        System.out.println(array.get(0));
        System.out.println(value[0]);
    }

    @Test
    public void ss() {
        ArrayList<a> a = new ArrayList<>();
        ArrayList<b> b = new ArrayList<>();
        ArrayList<? extends a> b1 = b;
        List<concurrent.c> b11 = (List<c>) b1;
        b11.add(new c());
        concurrent.c b3 = b11.get(3);
        ArrayList<? super b> b2 = b;
    }

    public static <T extends a>void gg(List<T> list) {
        List<a> as = (List<a>) list;

    }
    @Test
    public void atomicreftest() {
        AtomicReference<IntHolder> ref = new AtomicReference<>();
        ref.set(holder);
        IntHolder h2 = new IntHolder(4);
        ref.compareAndSet(holder, h2);
        System.out.println(ref.get().value);
    }

    @Test
    public void fieldtest() {
        user b = new user();
        AtomicIntegerFieldUpdater<user> a = AtomicIntegerFieldUpdater.newUpdater(user.class, "i");
        System.out.println(a.getAndIncrement(b));
        System.out.println(a.get(b));

    }

    @Test
    public void countdowntest() throws InterruptedException {
        CountDownLatch c = new CountDownLatch(2);
        new Thread(()->{
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println(3);
    }
}

class a {

}

class b extends a {
}

class c extends a {
}