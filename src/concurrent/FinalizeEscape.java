package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/10/14.
 */
public class FinalizeEscape {
    public static FinalizeEscape Hook = null;

    public void isAlive() {
        System.out.println("aived");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("executed");
        FinalizeEscape.Hook=this;
    }

    public static void main(String[] args) throws InterruptedException {
        Hook = new FinalizeEscape();
        Hook=null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if (Hook != null) {
            Hook.isAlive();
        }else System.out.println("died");
//        Hook = new FinalizeEscape();
        Hook=null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if (Hook != null) {
            Hook.isAlive();
        }else System.out.println("died");
    }
}
