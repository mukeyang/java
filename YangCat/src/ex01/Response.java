package ex01;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by CS on 2018/4/27.
 */
public class Response {
    OutputStream outputStream;
    Request request;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        Path path = Paths.get(HttpServer.WEB_ROOT).resolve(request.getUri());
        System.out.println(path.toAbsolutePath());
        if (!Files.exists(path)) {
            outputStream.write("404".getBytes());
            return;
        }
        byte[] bytes = Files.readAllBytes(path);

        outputStream.write(bytes);

    }
}
