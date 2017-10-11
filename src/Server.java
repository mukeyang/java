import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CS on 2017/9/13.
 */
public class Server {
    public static void main(String[] args) throws  Exception{
        try (ServerSocket s=new ServerSocket(8080)) {
            try (Socket coming=s.accept()){
                InputStream inputStream = coming.getInputStream();
                OutputStream outputStream = coming.getOutputStream();
                try (Scanner in = new Scanner(inputStream)) {
                    PrintWriter writer = new PrintWriter(outputStream, true);
                    Boolean done=false;
                    while (!done && in.hasNextLine()) {
                        String s1 = in.nextLine();
                        System.out.println(s1);
                        if(s1.equalsIgnoreCase("bye"))
                            done=true;

                    }
                }
            }
        }

    }
}
