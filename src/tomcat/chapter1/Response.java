package tomcat.chapter1;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by CS on 2017/12/29.
 */
public class Response {
//    public static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream out;

    public Response(OutputStream out) {
        this.out = out;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        Path path = Paths.get(HttpServer.WEB_ROOT,request.getUri());
        System.out.println("path="+path.toAbsolutePath());
        handle(path, out);
    }

    public static void handle(Path path, OutputStream out) throws IOException {
        if (Files.exists(path)) {
            byte[] bytes = Files.readAllBytes(path);
            out.write(bytes);
        } else {
            String errorMsg = "HTTP/1.1 404 File Not Found \r\n"
                    + "Content-Type=text/html\r\n"
                    + "Content-Length=23\r\n"
                    + "\r\n"
                    + "<h1>File Not Found</h1>";
            out.write(errorMsg.getBytes());
        }
    }
}
