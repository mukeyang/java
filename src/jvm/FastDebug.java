package jvm;

/**
 * Created by CS on 2017/11/24.
 */
public class FastDebug {
    public static final int Num=15000;

    public static int doubleValue(int i) {
        for (int j = 0; j < 100000; j++) ;
            return i*2;

    }

    public static long calcSum() {
        long sum=0;
        for (int i = 0; i < 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    /**
     * -XX:+PrintCompilationsx
     * -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < Num; i++) {
            calcSum();
        }
//        CompletableFuture.supplyAsync(()->)
    }
}
