import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

import java.time.LocalDate;

/**
 * Created by CS on 2018/3/24.
 */
public class helloImpl3 implements HelloApi, BeanFactoryAware, BeanNameAware {
    private String msg;
    private int index;
    private BeanFactory f;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

    public HelloApi getH() {
        return h;
    }

    public void setH(HelloApi h) {
        this.h = h;
    }

    private HelloApi h;

    public helloImpl3(String msg, int index) {
        this.msg = msg;
        this.index = index;
        System.out.println("init");
//        System.out.println(hello);
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
        System.out.println(date);
        System.out.println(f.getBean("hello"));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.f = beanFactory;
    }

    @Override
    public void setBeanName(String name) {

    }
}
