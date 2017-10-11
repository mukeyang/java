package thinkinginjava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by CS on 2017/10/11.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constrains {
    boolean primary() default  false;
    boolean allowNull() default true;
    boolean unique() default  false;
}
