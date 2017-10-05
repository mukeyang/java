import java.lang.reflect.Method;

/**
 * Created by CS on 2017/9/29.
 */
public class tracker {
    public static void main(String[] args) {
        Method[] methods = Pd.class.getDeclaredMethods();
        for (Method method : methods) {
            userCase annotation = method.getAnnotation(userCase.class);
            if (annotation != null) {
                System.out.println(annotation.id());
            }
        }
    }
}

class Pd {
    @userCase(id =1,des = "1")
    public void tp() {

    }
@userCase(id =2)
    public void g() {

    }
}