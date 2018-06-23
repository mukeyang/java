package ex02;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by CS on 2018/6/13.
 */
public class ServletProcessor1 {
    public static void main(String[] args) throws Exception {
        URLClassLoader loader = new URLClassLoader(new URL[]{new URL("file://C:\\Users\\CS\\IdeaProjects\\java8\\out\\production\\YangCat")}, Thread.currentThread().getContextClassLoader());
        System.out.println(loader.loadClass("ex02.test"));
    }
//    public void process(Request request, ex01.Response response) {
//        String uri = request.getUri();
//        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
//        URLClassLoader loader = null;
//
//    }
}
