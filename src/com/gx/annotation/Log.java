package com.gx.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    public String operationType() default "";
    public String operation() default "";
}
