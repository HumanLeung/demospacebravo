package com.example.demospacebravo.utils;

import javassist.ClassPool;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class JavassistUtils {

    public void generateClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = ClassPool.getDefault().getClassLoader();;
        Class<?> clazz = classLoader.loadClass("com.example.demospacebravo.dto.PersonDto");
        Object person = clazz.newInstance();
        Method setAge = clazz.getMethod("setAge", Integer.class);
        Method setName = clazz.getMethod("setName", String.class);
        setAge.invoke(person,1);
        setName.invoke(person,"名词");
        System.out.println(person);

    }
}
