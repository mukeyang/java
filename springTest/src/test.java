import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by CS on 2018/3/24.
 */

public class test {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("springTest\\config\\config.xml");
        HelloApi hello = context.getBean("hello", HelloApi.class);
        HelloApi hello2 = context.getBean("h2", HelloApi.class);
        hello.sayHello();
        hello2.sayHello();
    }
}
