package jvm;

/**
 * Created by CS on 2017/11/14.
 */
public class ByteUtils {
    public static int b2i(byte[] b, int start, int len) {
        int sum=0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n=((int)b[i])&0xff;
            n<<=(--len)*8;
            sum+=n;
        }
        return sum;
    }

    public static byte[] i2b(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len-i-1]=(byte)((value>>8*i)&0xff);
        }
        return b;
    }

    public static String b2s(byte[] n, int start, int len) {
        return new String(n, start, len);
    }

    public static byte[] s2b(String string) {
        return string.getBytes();
    }

    public static byte[] bytesReplace(byte[] origin, int offset, int len, byte[] replace) {

        byte[] newBytes = new byte[origin.length + (replace.length - len)];
        System.arraycopy(origin, 0, newBytes, 0, offset);
        System.arraycopy(replace, 0, offset, 0, replace.length);
        System.arraycopy(origin, offset + len, newBytes, offset + replace.length, origin.length - offset - len);
        return  newBytes;
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(300));
        System.out.println(Integer.toBinaryString(300>>8));
        System.out.println(Integer.toBinaryString((byte)(300)));
        System.out.println(Integer.toBinaryString((byte)(300&0xff)));
    }
}
