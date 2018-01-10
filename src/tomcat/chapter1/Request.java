package tomcat.chapter1;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by CS on 2017/12/21.
 */
public class Request {
    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public String getUri() {
        return uri;
    }

    public void parse() {
        try {
            int i=input.available();
            System.out.println("available="+i);
            byte[] buffer = new byte[i];
            i = input.read(buffer);
            System.out.println("read="+i);
            String request = new String(buffer);
            System.out.println("request="+request);
            uri = parseUri(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
//    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(" ");
        if (index1 != -1) {
            index2 = requestString.indexOf(" ", index1 + 1);
            if(index2>index1) return requestString.substring(index1+1,index2);
        }
        return null;
    }

}
