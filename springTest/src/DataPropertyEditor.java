import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by CS on 2018/6/14.
 */
public class DataPropertyEditor extends PropertyEditorSupport {
    public String getDataPattern() {
        return dataPattern;
    }

    public void setDataPattern(String dataPattern) {
        this.dataPattern = dataPattern;
    }

    private String dataPattern;


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataPattern);
        LocalDate date = LocalDate.parse(text, formatter);
        setValue(date);
    }
}
