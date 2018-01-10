package tomcat.chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CS on 2018/1/2.
 */
public class HttpServer1 {
    public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;
    public static final String WEB_ROOT = "C:\\Users\\CS\\IdeaProjects\\java8\\out\\production\\java8\\tomcat\\chapter2";

    public static void main(String[] args) {
        HttpServer1 server1 = new HttpServer1();
        server1.await();
        System.out.println(new HttpServer1().getClass().getResource("/cache.class"));
//        System.out.println(System.getProperty("java.class.path"));
    }

    private void await() {
        int port=8080;
        try (ServerSocket serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));) {
            while (!shutdown) {
                try (Socket accept = serverSocket.accept()) {
                    InputStream inputStream = accept.getInputStream();
                    OutputStream outputStream = accept.getOutputStream();
                    Request request = new Request(inputStream);
                    request.parse();
                    Response response = new Response(outputStream);
                    response.setRequest(request);
                    if (request.getUri().startsWith("/servlet/")) {
                        ServletProcessor1 processor1 = new ServletProcessor1();
                        processor1.process(response, request);
                    } else {
                        SendStaticProcessor processor = new SendStaticProcessor();
                        processor.process(request,response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
