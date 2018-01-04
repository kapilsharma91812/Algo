package com.experiment;

/**
 * Created by kapilsharma on 21/12/17.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //can use in method only.
public @interface Test {

    //should ignore this test?
    public boolean enabled() default true;

}
