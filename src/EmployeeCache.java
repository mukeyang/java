import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EmployeeCache {
    public static void main(String[] args) throws InterruptedException {
        EmployeeCache cache = EmployeeCache.getInstance();
        for (int i = 0; i < 60000000; i++) {
            cache.getEmployee(String.valueOf(i));
        }
    }


    //单例  
    private static EmployeeCache cache;

    //容器  
    private Map<String, WeakEmployee> referent;

    //引用队列当SoftEmployee对象中的目标对象被销毁后 会自定把SoftEmployee对象加入到该序列中  
    //这样就可以及时的清掉没有目标对象的SoftEmployee  
    private ReferenceQueue<Employee> queue;

    //同步锁  
    private static Object lock = new Object();

    //继承SoftReference,实现对对象的软引用  
    //这个类所引用的目标对象会在JVM内存不足时自动回收  
    private class WeakEmployee extends WeakReference<Employee> {

        private String key;

        public String getKey() {
            return key;
        }

        public WeakEmployee(Employee referent, ReferenceQueue<Employee> queue) {
            super(referent, queue);
            this.key = referent.getId();
        }

    }


    public synchronized Employee getEmployee(String id) {
        Employee e = null;
        if(referent.containsKey(id)) {
            e = referent.get(id).get();
        }
        if(e == null) {
            e = new Employee(id);
            cacheEmployee(e);
        }
        return e;
    }

    //缓存对象  
    private void cacheEmployee(Employee e) {
        cleanCache();// 清除垃圾引用  
        WeakEmployee ref = new WeakEmployee(e, queue);
        referent.put(e.getId(), ref);
    }

    //私有化构造参数  
    private EmployeeCache() {
        this.referent = Collections.synchronizedMap(new HashMap<String, WeakEmployee>());
        this.queue = new ReferenceQueue<Employee>();
    }

    //获得实例  
    public static EmployeeCache getInstance() {
        if(cache == null) {
            synchronized (lock) {
                if(cache == null) {
                    cache = new EmployeeCache();
                }
            }
        }
        return cache;
    }

    //将SoftEmployee中目标元素为空的对象清除  
    private void cleanCache() {
        WeakEmployee se = null;
        while((se = (WeakEmployee)queue.poll()) != null) {
            referent.remove(se.getKey());
            System.out.println("对象ID : " + se.getKey() + "已经被JVM回收");
        }
    }

    public int getSize() {
        return referent.size();
    }

    //清除缓存  
    public void clearCache() {
        cleanCache();
        referent.clear();
    }

}

class cache {
    private static cache cache;
    private  Map<String,weak> referent;
    private ReferenceQueue<Employee> queue;
    private static Object lock=new Object();
    private class weak extends WeakReference<Employee> {
        private  String key;

        public weak(Employee referent, ReferenceQueue<? super Employee> q) {
            super(referent, q);
            this.key = referent.getId();
        }
    }

    public synchronized Employee getEmployee(String id) {
        Employee e=null;
        if (referent.containsKey(id)) {
            e=referent.get(id).get();
        }
        if (e == null) {
            e = new Employee(id);
            cacheEmployee(e);
        }
        return e;
    }

    private void cacheEmployee(Employee e) {
        cleanCache();
        weak weak = new weak(e,queue);
        referent.put(e.getId(), weak);
    }

    private void cleanCache() {
        weak e=null;
        while ((e = ((weak) queue.poll())) != null) {
            referent.remove(e.key);
            System.out.println("对象ID : " + e.key + "已经被JVM回收");
        }
    }
}
class Employee {

    private String id;

    private String name;

    public Employee(String id) {
        this.id = id;
        this.name = String.valueOf(System.currentTimeMillis());
        //System.out.println("Employee.Employee() ..从数据库中或者其他资源获取对象");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}