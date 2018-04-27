package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by CS on 2018/3/29.
 */
@Component("c1")
public class SgtPeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.println("setPeppers");
    }
}
