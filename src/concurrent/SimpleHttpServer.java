package concurrent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by CS on 2017/10/14.
 */
public class SimpleHttpServer {
//    static String basePath;
    static ServerSocket serverSocket;
    static int port = 8080;
    static String basePath=System.getProperties().getProperty("user.dir");
static ThreadPool<HttpRequestHandler> pool=new DeafaltThreadPool<>(10);
    public static void setPort(int port) {
        SimpleHttpServer.port = port;
    }

    public static void setBasePath(String basePath) {
        SimpleHttpServer.basePath = basePath;
    }

    static class HttpRequestHandler implements Runnable {
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = socket.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                 PrintStream out = new PrintStream(socket.getOutputStream());

            ){
                String header = reader.readLine();
                System.out.println(header);
                String path = basePath + header.split(" ")[1];
                System.out.println(path);
                if (path.endsWith("jpg") || path.endsWith("ico")) {
                    byte[] bytes = Files.readAllBytes(Paths.get(path));
                    System.out.println("length"+bytes.length);
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server:Yang");
                    out.println("Content-Type:image/jpeg");
                    out.println("Content-Length:" + bytes.length);
                    out.println(" ");
                    out.write(bytes);
                } else {
                    List<String> lines = Files.readAllLines(Paths.get(path));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server:Yang");
                    out.println("Content-Type:text/html;charset=UTF-8");
//                    out.println("Content-Length:" + bytes.length);
                    out.println(" ");
//                    out.write(lines);
                    lines.forEach(out::println);
                }
            } catch (IOException e) {
//                System.out.println();
                for (Throwable throwable : e.getSuppressed()) {
                    throwable.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
         serverSocket = new ServerSocket(port);
        Socket socket=null;
         while ((socket = serverSocket.accept()) != null) {
            pool.execute(new HttpRequestHandler(socket));
        }
    }
}
