import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CS on 2017/9/13.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        String q;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        Scanner scanner = new Scanner(System.in);
        q=scanner.nextLine();
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        while (!(s=reader.readLine()).equals("bye")){
            System.out.println(s);
        }
    }
}
