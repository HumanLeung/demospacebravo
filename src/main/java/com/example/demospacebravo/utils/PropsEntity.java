package com.example.demospacebravo.utils;

import lombok.AllArgsConstructor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@AllArgsConstructor
public class PropsEntity {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFields() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        final Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++){
            Field field = fields[i];
            String fieldName = field.getName();
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),this.getClass());
            Method getMethod = pd.getReadMethod();
            Object o = getMethod.invoke(this);
            System.out.println(getMethod);
            System.out.println(o);
        }
        return null;
    }
}
