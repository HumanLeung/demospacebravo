package com.example.demospacebravo.Annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Demo {
    String name() default "";
}
