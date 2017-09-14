package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CS on 2017/9/14.
 */
public class client {
    public static void main(String[] args) {
        new blockingclient().run();
    }
}

class blockingclient {
    public void run() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("127.0.0.1",7878));
            Scanner in = new Scanner(System.in);
            Scanner coming=new Scanner(socket.getInputStream());
            while (true) {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("123");
                if(in.hasNextLine()){
                    String s = in.nextLine();
                    writer.println(s);}
                if (coming.hasNext()) {
                    System.out.println("return"+coming.nextLine());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}