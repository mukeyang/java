import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;
import java.time.LocalDate;

/**
 * Created by CS on 2018/6/14.
 */
public class DateRegister implements PropertyEditorRegistrar {
    private PropertyEditor editor;

    public PropertyEditor getEditor() {
        return editor;
    }

    public void setEditor(PropertyEditor editor) {
        this.editor = editor;
    }

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(LocalDate.class, editor);
    }
}
