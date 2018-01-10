package tomcat.chapter2;

import java.io.IOException;

/**
 * Created by CS on 2018/1/2.
 */
public class SendStaticProcessor {
    public static void main(String[] args) throws Exception {
//        URL url = new File("C:\\Users\\CS\\IdeaProjects\\java8\\out\\production\\java8\\tomcat\\chapter2").toURI().toURL();
//        System.out.println(url);
//        URLClassLoader loader = new URLClassLoader(new URL[]{url});
//        Class<?> request = loader.loadClass("tomcat.chapter2.Request");
//        System.out.println(request);
        System.out.println(String.class.getResource("Math.class"));
        System.out.println(SendStaticProcessor.class.getResource("/"));
    }
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
