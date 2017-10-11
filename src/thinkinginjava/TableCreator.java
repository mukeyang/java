package thinkinginjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS on 2017/10/11.
 */
public class TableCreator {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Class.forName("thinkinginjava.Member");
        DBTable dbTable = c1.getAnnotation(DBTable.class);
        if (dbTable == null) {
            System.out.println("no datable annocation");
            return;
        }
        String tableName = dbTable.name();
        if (tableName.length() < 1) {
            tableName = c1.getName().toUpperCase();
        }
        List<String> column = new ArrayList<>();
        for (Field field : c1.getDeclaredFields()) {
            String columnName=null;
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length<1)
                continue;
            if (annotations[0] instanceof SQLInteger) {
                SQLInteger integer = (SQLInteger) annotations[0];
                if(integer.name().length()<1)
                    columnName=field.getName().toUpperCase();
                else
                    columnName = integer.name();
                column.add(columnName+" INT"+getConstraints(integer.constraints()));
            }
            if (annotations[0] instanceof SQLString) {
                SQLString SS = (SQLString) annotations[0];
                if(SS.name().length()<1)
                    columnName=field.getName().toUpperCase();
                else
                    columnName=SS.name();
                column.add(columnName + " VARVCHAR(" + SS.value() + ")" + getConstraints(SS.constrains()));
            }
        }
        StringBuilder builder = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String s : column)
            builder.append("\n" + s + ",");
            builder.deleteCharAt(builder.length() - 1);
            System.out.println(builder.append(");"));

    }

    private static String getConstraints(Constrains constraints) {
        StringBuilder buf = new StringBuilder();
        if(!constraints.allowNull()) buf.append(" NOT NULL");
        if(constraints.primary()) buf.append(" PRIMARY KEY");
        if(constraints.unique()) buf.append(" UNIQUE") ;
        return buf.toString();      }
}
