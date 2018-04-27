/**
 * Created by CS on 2018/3/24.
 */
public class helloImpl3 implements HelloApi {
    private String msg;
    private int index;

    public helloImpl3(String msg, int index) {
        this.msg = msg;
        this.index = index;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void sayHello() {
        System.out.println(msg);
    }
}
