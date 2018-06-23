package ex02;

import java.io.File;
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
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

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
