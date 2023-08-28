package com.example.demospacebravo.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public abstract class FunctionalInterface {

    static public void getAllFields(FunctionDemo demo){
        demo.doWith("k2");
    }

    interface FunctionDemo{
        void doWith(String field);
    }
}
