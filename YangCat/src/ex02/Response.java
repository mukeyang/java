package ex02;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

/**
 * Created by CS on 2018/6/13.
 */
public class Response implements ServletResponse {
    public static final int BUFFER_SIZE = 1024;
    Request request;

    public void setRequest(Request request) {
        this.request = request;
    }

    OutputStream outputStream;
    PrintWriter writer;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void sendStaticResource() throws IOException {
        Path path = Paths.get(ServletServer.WEB_ROOT).resolve(request.getUri());
        System.out.println(path.toAbsolutePath());
        if (!Files.exists(path)) {
            outputStream.write("404".getBytes());
            return;
        }
        byte[] bytes = Files.readAllBytes(path);

        outputStream.write(bytes);

    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        PrintWriter writer = new PrintWriter(outputStream, true);
        return writer;
    }

    @Override
    public void setCharacterEncoding(String s) {

    }

    @Override
    public void setContentLength(int i) {

    }

    @Override
    public void setContentType(String s) {

    }

    @Override
    public void setBufferSize(int i) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
