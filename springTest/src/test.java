import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by CS on 2018/3/24.
 */

public class test {
    public static void main(String[] args) {
        System.out.println(
        );
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions("classpath:config.xml");
//        for (String s : factory.getBeanDefinitionNames()) {
//            System.out.println(s);
//        }


        ApplicationContext factory = new FileSystemXmlApplicationContext("springTest\\config\\config.xml");
//        new ControlFlowPointcut()
        System.out.println(factory.getResource("d:"));
//        new ApplicationContext()
        //
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        configurer.setLocation(new ClassPathResource("1.xml"));
//        configurer.postProcessBeanFactory(factory);

        HelloApi bean = factory.getBean("byindex", HelloApi.class);
//        factory.getBean()
        bean.sayHello();
        bean.sayHello();
        System.out.println(bean);

//        HelloApi hello = context.getBean("hello", HelloApi.class);
//        HelloApi hello2 = context.getBean("gg", HelloApi.class);
//        hello.sayHello();
//        hello2.sayHello();
//        System.out.println(Arrays.toString(context.getAliases("hello")));
//        context.getBean("byindex",HelloApi.class).sayHello();
    }
}
