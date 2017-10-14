package concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by CS on 2017/10/11.
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] infos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info : infos) {
            System.out.println(info.getThreadId()+" "+info.getThreadName());
        }
//        Stream.iterate(0,i->i+1).limit(100).parallel().forEach(System.out::println);

    }
}
