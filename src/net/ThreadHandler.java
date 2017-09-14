package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CS on 2017/9/14.
 */
public class ThreadHandler implements Runnable {
    Socket i;
    public ThreadHandler(Socket accept) {
        i=accept;
        System.out.println(i);
    }

    @Override
    public void run() {
        System.out.println("run");
        try {
            try {
                InputStream inputStream = i.getInputStream();
                OutputStream outputStream = i.getOutputStream();
                Scanner scanner = new Scanner(inputStream);
                PrintWriter writer = new PrintWriter(outputStream, true);
                boolean done=false;
                boolean b = scanner.hasNextLine();
                System.out.println(b);
                while (!done) {
                    System.out.println("run");
                    if(scanner.hasNextLine()) {String line = scanner.nextLine();
                    System.out.println("echo"+line);
                    writer.println(line);
                    if(line.equals("88")) done=true;}
                }
            }  finally {
                i.close();

            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
