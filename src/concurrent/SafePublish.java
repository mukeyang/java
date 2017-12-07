package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/12/5.
 */
public class SafePublish {
    private final p p1;

    public void m() {
        ((p) () -> System.out.println("1" + SafePublish.this)).j();
        new Thread(() -> System.out.println(SafePublish.this)).start();
    }

    SafePublish() {
        p1=()-> System.out.println("ok");
    }

    public static p newInstance() {
        return new SafePublish().p1;
    }
    public static void main(String[] args) throws InterruptedException {
        new SafePublish().m();
        TimeUnit.SECONDS.sleep(10);
    }
}
@FunctionalInterface
interface p {
    void j();
}
