package net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by CS on 2017/9/15.
 */
public class url {

    @Test
    public void ss() {
        this.dd();
    }
        @SuppressWarnings("unchecked")
    public  <T>void dd() {

            T[] a1 = (T[])new Object[3];
            for (int i = 0; i < a1.length; i++) {
                a1[i]=(T)new  Object();
            }
        }
    public static void main(String[] args) {
        try {
            URL u = new URL("http://127.0.0.1:8080/hello");
//            URL u = new URL("http://172.16.200.11");
            HttpURLConnection connection = ((HttpURLConnection) u.openConnection());
//            connection.connect();
            Properties p = new Properties();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            try (InputStream inputStream = Files.newInputStream(Paths.get("3"))
            ) {
                    p.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Map.Entry<Object, Object> entry : p.entrySet()) {
                String key = (String) entry.getKey();
                String value= (String) entry.getValue();
//                System.out.println(value);
                connection.addRequestProperty(key, value);
            }
//            String s = Base64.getEncoder().encodeToString("".getBytes());
//            connection.setRequestMethod("POST");
//            connection.connect();
            connection.setRequestProperty("Charset",("UTF-8"));
            System.out.println(connection.getRequestProperty("Charset"));

            try (PrintWriter writer = new PrintWriter(connection.getOutputStream())) {

                writer.print("DDDDD=" + "2016111028"+"&");
                writer.print("upass=" + URLEncoder.encode("4034787", "UTF-8")+"&");
                writer.print("0MKKey=" + URLEncoder.encode("123", "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                System.out.println(entry.toString());
            }
            try (Scanner in = new Scanner(connection.getInputStream(),"gbk")
            ) {
                while (in.hasNextLine())
                    System.out.println(in.nextLine());

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

