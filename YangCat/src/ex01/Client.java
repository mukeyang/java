package ex01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by CS on 2018/5/2.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        char a = 65535;
        System.out.println(Integer.MAX_VALUE);
        System.out.println("你好".getBytes().length);
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 8080));
        socket.getOutputStream().write("GET /1.html HTTP/1.1".getBytes());
        byte[] b = new byte[1024];
        socket.getInputStream().read(b);
        System.out.println(b);
    }
}
