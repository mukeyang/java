package thinkinginjava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by CS on 2017/9/5.
 */

interface servive {
    default void s() {
        System.out.println("default");
    }
}

public class proxy implements InvocationHandler {


    public static void main(String[] args) {
        Object o = new proxy(new servive() {
        }).geyProxy();
        ((servive) o).s();
    }
    private Object target;

    public proxy(Object target) {
        this.target = target;
    }
    public  proxy() {

    }

    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        getClass().getConstructor()
        System.out.println("before");
        Object o = method.invoke(target, args);
        System.out.println("After");
        return o;
    }

    public Object geyProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
