package com.example.demospacebravo.utils;

import org.springframework.util.ReflectionUtils;

/**
 * @author 梁晓明
 */
public class SpringReflectUtils {
    public static void fillPropsInRelEntityOnPersist(){
        FunctionalInterface.FunctionDemo functionDemo = field -> {
            System.out.println(field.getClass());
            System.out.println(field);
        };
        FunctionalInterface.getAllFields(functionDemo);
    }

    public static void main(String[] args) {
//        fillPropsInRelEntityOnPersist();
//         ReflectionUtils.
    }
}
