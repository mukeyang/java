package tomcat.chapter3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CS on 2018/1/4.
 */
public class HttpConnector implements Runnable {
    boolean stoped;
    private String scheme = "http";

    public String getScheme() {
        return scheme;
    }

    @Override
    public void run() {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"))) {
            while (!stoped) {
                try (Socket socket = serverSocket.accept()) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
