package net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

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
            URL u = new URL("http://172.16.200.13");
            URLConnection connection = u.openConnection();
//            connection.connect();
            Properties p = new Properties();
            connection.setDoOutput(true);
            try (InputStream inputStream = Files.newInputStream(Paths.get("3"))
            ) {
                    p.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Map.Entry<Object, Object> entry : p.entrySet()) {
                String key = (String) entry.getKey();
                String value= (String) entry.getValue();
                connection.setRequestProperty(URLEncoder.encode((key+":"),"utf-8"),URLEncoder.encode(value,"utf-8"));
            }
            try (PrintWriter writer = new PrintWriter(connection.getOutputStream());) {

                writer.println("DDDDD=" + URLEncoder.encode("2016111028", "UTF-8"));
                writer.println("upass=" + URLEncoder.encode("4034787", "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                System.out.println(entry.toString());
            }
            try (Scanner in = new Scanner(connection.getInputStream())
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
