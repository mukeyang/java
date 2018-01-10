package tomcat.chapter2;

import tomcat.chapter1.HttpServer;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

/**
 * Created by CS on 2018/1/2.
 */
public class Response implements ServletResponse {
    Request request;
    OutputStream output;
    PrintWriter writer;

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response(OutputStream output) {

        this.output = output;
    }
    public void sendStaticResource() throws IOException {
        Path path = Paths.get(HttpServer.WEB_ROOT,request.getUri());
        System.out.println("path="+path.toAbsolutePath());
        tomcat.chapter1.Response.handle(path,output);
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
        writer = new PrintWriter(output, true);
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
