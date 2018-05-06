package ex01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CS on 2018/4/27.
 */
public class HttpServer {
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    public static final String SHUTDOWN = "/SHUTDOWN";
    private boolean shutdown = false;

    public void await() {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!shutdown) {
                try (Socket socket = serverSocket.accept()) {
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();
                    Request request = new Request(in);
                    request.parse();
                    Response response = new Response(out);
                    response.setRequest(request);
                    response.sendStaticResource();
                    shutdown = request.getUri().equals(SHUTDOWN);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();

    }
}
