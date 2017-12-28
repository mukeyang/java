package tomcat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by CS on 2017/12/20.
 */
public class HttpServer {
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) throws UnknownHostException {
        for (byte b : InetAddress.getLocalHost().getAddress()) {
            System.out.println(b);
        }
    }
    public void await() {
        int port=8080;
        try (ServerSocket serverSocket = new ServerSocket(port, 1, InetAddress.getLocalHost())) {
            try (Socket socket = serverSocket.accept();) {

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                try (Scanner scanner = new Scanner(in)) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
