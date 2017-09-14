package net;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by CS on 2017/9/14.
 */
public class Server {
    public static void main(String[] args) {
        new BlockingServer().run(7878);
//        new unblockingServer().run(8080);
//new ThreadBlockingServer().run(7878);}
    }
}
class BlockingServer {
    public void run(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            try (Socket socker = server.accept()) {
                InputStream inputStream = socker.getInputStream();
                OutputStream outputStream = socker.getOutputStream();
                try(Scanner in=new Scanner(inputStream)) {
                    boolean done=false;
                    PrintWriter writer = new PrintWriter(outputStream, true);
                    while (!done && in.hasNextLine()) {
                        String s = in.nextLine();
                        writer.println(s);
                        if(s.equalsIgnoreCase("88")) done=true;
                        System.out.println("server:"+s);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class unblockingServer {
    public void run(int port) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()){
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int num = selector.select();
                System.out.println(num);
                if(num==0) continue;
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {

                    SelectionKey next = iterator.next();
                    if (next.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                        SocketChannel accept = channel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector,SelectionKey.OP_READ);
                       sayhello(accept);
                    }
                    if (next.isReadable()) {
                        SocketChannel channel = (SocketChannel) next.channel();
                        readdata(channel);
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {


        }
    }

    private void sayhello(SocketChannel accept) {
        try (Writer writer = Channels.newWriter(accept, "utf-8")){
            writer.write("say jello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readdata(SocketChannel channel) {
        System.out.println("read");
//        Reader reader = Channels.newReader(channel,"utf-8");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int n;
        try {
            while ((n = channel.read(buffer)) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println(buffer.getChar());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadBlockingServer {
    public void run(int port) {
        try{
            int i=1;
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket accept = server.accept();
                System.out.println(accept.getLocalPort());
                Runnable r=new ThreadHandler(accept);
                Thread thread = new Thread(r);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
