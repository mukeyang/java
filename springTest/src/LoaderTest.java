import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * Created by CS on 2018/6/14.
 */
public class LoaderTest {
    public static void main(String[] args) {
        DefaultResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("D:/hhfh");
        System.out.println(resource.exists());
    }
}
