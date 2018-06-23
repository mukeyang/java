package ex02;

import java.io.IOException;

/**
 * Created by CS on 2018/6/13.
 */
public class StaticResourceProcessor {
    public void process(Request request, ex01.Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
