/**
 * Created by CS on 2018/3/24.
 */
public class HeoolImpl implements HelloApi {
    public HeoolImpl() {
    }

    public HeoolImpl(String s) {
        System.out.println(s);
    }

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
