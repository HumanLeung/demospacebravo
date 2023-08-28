package com.example.demospacebravo.utils;

import com.example.demospacebravo.Annotation.IndustryExt;
import org.reflections.Reflections;

import java.util.Set;

public class ReflectionsTool {

    private static final String PACKAGE = "com.example.demospacebravo";

    public static void packageTest(){
        Reflections ocmReflections = new Reflections(PACKAGE);
//        System.out.println(ocmReflections.getTypesAnnotatedWith(IndustryExt.class));
        Set<Class<?>> classSet = ocmReflections.getTypesAnnotatedWith(IndustryExt.class);
        for (Class<?> clazz : classSet){
//            System.out.println(clazz);
            System.out.println(clazz.getSuperclass());
        }
    }
}
