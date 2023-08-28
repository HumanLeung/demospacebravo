package com.example.demospacebravo.utils;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class PropertyDescriptorDemo {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
          PropsEntity propsEntity = new PropsEntity("john",2);
          propsEntity.getFields();
    }
}
