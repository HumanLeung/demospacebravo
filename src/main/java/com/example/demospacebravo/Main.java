package com.example.demospacebravo;

import com.example.demospacebravo.dto.PersonDto;
import com.example.demospacebravo.utils.ReflectionsTool;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        inspect(PersonDto.class);
//          bigDecimal()
        ReflectionsTool.packageTest();
    }

    public static void bigDecimal(){
        BigDecimal bd1 = new BigDecimal("124567890.0987654321");
        System.out.println(bd1);
        BigDecimal bd2 = new BigDecimal("987654321.123456789");

        bd1 = bd1.add(bd2);
        System.out.println(bd1);

        // Multiplication of two BigDecimals
        bd1 = bd1.multiply(bd2);
        System.out.println("BigDecimal1 = " + bd1);

        // Subtraction of two BigDecimals
        bd1 = bd1.subtract(bd2);
        System.out.println("BigDecimal1 = " + bd1);

        // Division of two BigDecimals
        bd1 = bd1.divide(bd2);
        System.out.println("BigDecimal1 = " + bd1);

        // BigDecima1 raised to the power of 2
        bd1 = bd1.pow(2);
        System.out.println("BigDecimal1 = " + bd1);

        // Negate value of BigDecimal1
        bd1 = bd1.negate();
        System.out.println("BigDecimal1 = " + bd1);
    }
    static <T> void inspect(Class<T> klazz) {
        Field[] fields = klazz.getDeclaredFields();
        System.out.printf("%d fields:%n", fields.length);
        for (Field field : fields) {
            System.out.println(field.getType().getCanonicalName()+"------");
            System.out.printf("%s %s %s%n",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName()
            );
        }
    }
}
