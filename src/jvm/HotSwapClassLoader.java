package jvm;

/**
 * Created by CS on 2017/11/14.
 */
public class HotSwapClassLoader extends  ClassLoader{
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] bytes) {
        return defineClass(null, bytes, 0, bytes.length);
    }
}

class ClassModifier {
    /**
     * class 文件中的常量池的起始偏移
     */
    private static final  int CONSTANT_POOL_INDEX=8;
    public static final int CONSTANT_UTF8_info=1;
    private static final int[] CONSTANT_ITEM_LENGTH={-1,-1,-1,5,5,9,9,3,3,5,5,5,5};
    public static final int u1=1;
    public static final int  u2=2;
    private byte[] classBytes;

    public ClassModifier(byte[] clsssBytes) {
        this.classBytes = clsssBytes;
    }

    public int getConstantPoolCount() {
        return ByteUtils.b2i(classBytes, CONSTANT_POOL_INDEX, u2);
    }

    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        int cpc = getConstantPoolCount();
        int offset=CONSTANT_POOL_INDEX+u2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.b2i(classBytes, offset, u1);
            if (tag == CONSTANT_UTF8_info) {
                int len = ByteUtils.b2i(classBytes, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.b2s(classBytes, offset, len);
                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] strBytes = ByteUtils.s2b(newStr);
                    byte[] strlen = ByteUtils.i2b(newStr.length(), u2);
                    classBytes = ByteUtils.bytesReplace(classBytes, offset - u2, u2, strlen);
                    classBytes = ByteUtils.bytesReplace(classBytes, offset, len, strBytes);
                    return classBytes;
                } else {
                    offset+=len;
                }
            } else offset += CONSTANT_ITEM_LENGTH[tag];
        }
        return classBytes;
    }
}