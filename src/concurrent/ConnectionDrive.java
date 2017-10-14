package concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created by CS on 2017/10/14.
 */
public class ConnectionDrive {
    static class ConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy");
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    public static Connection createConnection() {
        Object o = Proxy.newProxyInstance(ConnectionDrive.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
        return ((Connection) o);
    }

    public static void main(String[] args) {
        System.out.println(createConnection());
    }
}
