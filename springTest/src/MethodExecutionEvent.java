import java.util.EventObject;

/**
 * Created by CS on 2018/6/14.
 */
public class MethodExecutionEvent extends EventObject {
    private String name;

    public MethodExecutionEvent(Object soucrce, String name) {
        super(soucrce);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MethodExecutionEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
