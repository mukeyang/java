/**
 * Created by CS on 2018/5/6.
 */
public interface Hello<T> {
    String hello(T name);
}

class Helloimp<T> implements Hello<T> {
    @Override
    public String hello(T name) {
        return "hello" + name;
    }
}

class RpcProvider {
    public static void main(String[] args) {
        Hello imp = new Helloimp();
        RPCFramework.export(imp, 1234);
    }
}

class RpcConsum {
    public static void main(String[] args) throws Exception {
        Hello refer = RPCFramework.refer(Hello.class, "127.0.0.1", 1234);
        String rpc = refer.hello(123);
        System.out.println(refer);
    }
}