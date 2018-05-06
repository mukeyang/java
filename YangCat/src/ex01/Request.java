package ex01;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by CS on 2018/4/27.
 */
public class Request {
    private InputStream in;

    public String getUri() {
        String s = uri.substring(1);
        return s;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    private String uri;

    public Request(InputStream in) {
        this.in = in;
    }

    public void parse() {
        Scanner scanner = new Scanner(in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
        System.out.println("request=" + line);
            uri = parseUri(line);
        }
    }

    public String parseUri(String line) {
        String[] strings = line.split(" ");
        if (strings.length != 3) return null;
        System.out.println("parse uri=" + Arrays.toString(strings));
        return strings[1];
    }
}
