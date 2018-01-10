package tomcat.chapter2;

import javax.servlet.Servlet;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * Created by CS on 2018/1/2.
 */
public class ServletProcessor1 {
    public void process(Response response, Request request) {
        try {
            String uri = request.getUri();
            String name = uri.substring(uri.lastIndexOf("/") + 1);
            URLClassLoader loader;
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(HttpServer1.WEB_ROOT);
//            String repository=new URL("file",null, classPath.getCanonicalPath()+File.separator).toString();
            System.out.println("res="+classPath);
            urls[0] = classPath.toURI().toURL();
            System.out.println("url="+urls[0]);
            loader = new URLClassLoader(urls);
            System.out.println("name="+name);
            Class<?> myClass = loader.loadClass("tomcat.chapter2."+name);
            Servlet servlet = (Servlet) myClass.newInstance();
            servlet.service(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
