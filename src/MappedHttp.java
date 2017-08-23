import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by CS on 2017/8/23.
 */
public class MappedHttp {
    private static final String OUT_FILE = "1.txt";
    private static final String LINE_SEP = "\r\n";
    private static final String SERVER_ID = "yang";
    private static  final  String HTTP_HDR="HTTP/1.0 200 OK"+LINE_SEP+SERVER_ID+LINE_SEP;
    private static final String HTTP_404_HDR="HTTP/1.0 404 NOT Found"+LINE_SEP+SERVER_ID+LINE_SEP;
    private static final String MSG_404 = "file wrong";

    public static void main(String[] args) throws Exception {
        String file="1.txt";
        ByteBuffer header = ByteBuffer.wrap(bytes(HTTP_HDR));
        ByteBuffer dynhdrs = ByteBuffer.allocate(128);
        ByteBuffer[] gather={header,dynhdrs,null};
        String contentType = "unkown/unkown";
        long contentLength = -1;
        try {
            FileInputStream stream = new FileInputStream(file);
            FileChannel channel = stream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            gather[2] = map;
            contentLength = channel.size();
            contentType = URLConnection.guessContentTypeFromName(file);
        } catch (IOException e) {
            ByteBuffer buf = ByteBuffer.allocate(128);
            String msg = MSG_404 + e + LINE_SEP;
            buf.put(bytes(msg));
            buf.flip();
            gather[0] = ByteBuffer.wrap(bytes(HTTP_404_HDR));
            gather[2] = buf;
            contentLength = msg.length();
            contentType = "text/plain";

        }
        StringBuffer sb = new StringBuffer();
        sb.append("Content-Length:" + contentLength);
        sb.append(LINE_SEP);
        sb.append("Content-Type").append(contentType);
        sb.append(LINE_SEP).append(LINE_SEP);
        dynhdrs.put(bytes(sb.toString()));
        dynhdrs.flip();
        FileOutputStream fos = new FileOutputStream(OUT_FILE);
        FileChannel out = fos.getChannel();
        while (out.write(gather) > 0) {

        }
        out.close();
        System.out.println("writtten to " + OUT_FILE);


    }

    private static byte[] bytes(String string) throws UnsupportedEncodingException {
        return  string.getBytes("utf-8");
    }
}
