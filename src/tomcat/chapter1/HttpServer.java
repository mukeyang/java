package tomcat.chapter1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by CS on 2017/12/20.
 */
public class HttpServer {
    public static final String WEB_ROOT = System.getProperty("user.dir");
    public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) throws UnknownHostException {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        int port = 8080;
        while (!shutdown) {
            try (ServerSocket serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"))) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println(socket.getRemoteSocketAddress());
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();
                    Request request = new Request(in);
                    request.parse();
                    Response response = new Response(out);
                    response.setRequest(request);
                    response.sendStaticResource();
                    shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void ss() {
        System.out.println("pa");
    }
}
