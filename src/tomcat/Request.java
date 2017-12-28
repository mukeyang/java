package tomcat;

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
        StringBuffer requset = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        boolean loop = true;
        StringBuilder sb = new StringBuilder();
//        while (loop) {
////            if () {
//                int i;
//                while ((i=in.read()) != -1) {
//                    sb.append((char) i);
//                }
//                loop = false;
//            }
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
