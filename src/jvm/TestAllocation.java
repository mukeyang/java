package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS on 2017/10/27.
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmn10M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     */
    public static void test1() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];
    }

    /**
     * -verbose:gc -Xms20M -Xmn10M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
     */
    public static void test2() {
        byte[] a1 = new byte[4 * _1MB];
    }

    /**
     * -verbose:gc -Xms20M -Xmn10M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    public static void test3() {
        byte[] a1, a2, a3;
        a1 = new byte[_1MB / 4];
        a2 = new byte[4 * _1MB];
        a3 = new byte[4 * _1MB];
        a3 = null;
        a3 = new byte[4 * _1MB];
    }

    static class OOMObject {
        public byte[]placeHolder=new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<HeapOOm.OOMobject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new HeapOOm.OOMobject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {

        /*test3();
        TimeUnit.MINUTES.sleep(10);*/
        fillHeap(1000);

    }

}

