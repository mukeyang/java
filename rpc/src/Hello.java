/**
 * Created by CS on 2018/5/6.
 */
public interface Hello {
    String hello(String name);
}

class imp implements Hello {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}

class RpcProvider {
    public static void main(String[] args) {
        Hello imp = new imp();
        RPCFramework.export(imp, 1234);
    }
}

class RpcConsum {
    public static void main(String[] args) throws Exception {
        Hello refer = RPCFramework.refer(Hello.class, "127.0.0.1", 1234);
        String rpc = refer.hello("rpc");
        System.out.println(rpc);
    }
}