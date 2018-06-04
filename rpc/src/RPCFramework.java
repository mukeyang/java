import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CS on 2018/5/5.
 */
public class RPCFramework {
    public static void export(final Object service, int port) {
        if (service == null) {
            throw new IllegalArgumentException("service null");
        }
        if (port <= 0 || port > 65535) throw new IllegalArgumentException("port invaild");
        System.out.println("Export service" + service.getClass().getName() + "on port" + port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            try (Socket socket = serverSocket.accept()) {
                Thread thread = new Thread(() -> {
                    ObjectOutputStream outputStream1 = null;
                    try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                         ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())
                    ) {
                        outputStream1 = outputStream;
                        String name = inputStream.readUTF();
                        System.out.println(name);
                        Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                        Object[] arg = (Object[]) inputStream.readObject();
                        Method method = service.getClass().getMethod(name, parameterTypes);
                        Object result = method.invoke(service, arg);
                        outputStream.writeObject(result);

                    } catch (Throwable e) {
                        try {
                            outputStream1.writeObject(e);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        e.printStackTrace();
                    }
                });
                thread.start();
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static <T> T refer(Class<T> interfaceClass, final String host, final int port) throws Exception {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("interface =null");
        }
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public String toString() {
                return getClass().getName();
            }

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try (Socket socket = new Socket(host, port);
                     ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                    out.writeUTF(method.getName());
                    out.writeObject(method.getParameterTypes());
                    out.writeObject(args);
                    Object object = in.readObject();
                    if (object instanceof Throwable) {
                        throw (Throwable) object;
                    }
                    return object;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }
}
