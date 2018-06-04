package ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CS on 2018/5/18.
 */
public class ServletServer {
    public static final String SHUTDOWN = "/SHUTDOWN";
    private boolean shutdown = false;

    public void await() {
        try (ServerSocket serverSocket = new ServerSocket(8080);) {
            while (!shutdown) {
                try (Socket socket = serverSocket.accept();
                     InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream()) {


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
