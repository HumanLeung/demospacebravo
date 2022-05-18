package com.example.demospacebravo.iterator;

import com.example.demospacebravo.Annotation.Demo;
import com.example.demospacebravo.dto.PersonDto;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.IntegerMemberValue;
import javassist.bytecode.annotation.StringMemberValue;

import java.io.IOException;
import java.lang.reflect.Field;

public class CLassUtils {
    public static void main(String[] args) throws IllegalAccessException, NotFoundException, CannotCompileException, IOException {
      inspect(PersonDto.class);
    }
    //            System.out.printf("%s %s %s%n",
//                    Modifier.toString(field.getModifiers()),
//                    field.getType().getSimpleName(),
//                    field.getName()
//            );
    static <T> void inspect(Class<T> klazz) throws IllegalAccessException, NotFoundException, CannotCompileException, IOException {
        Field[] fields = klazz.getDeclaredFields();
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("PersonDtoShadow");
        ClassFile classFile = ctClass.getClassFile();
        ConstPool constPool = classFile.getConstPool();
        StringBuilder builder = new StringBuilder();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Demo.class)){
                String simpleName = field.getName();
                field.setAccessible(true);
                String name = field.getAnnotation(Demo.class).name();
                CtField value = new CtField(pool.get(field.getType().getCanonicalName()), simpleName,ctClass);
                value.setModifiers(javassist.Modifier.PRIVATE);
                System.out.println(field.getType().getSimpleName().equals("String"));

                AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
                javassist.bytecode.annotation.Annotation jsonFileAnnotation = new Annotation(Demo.class.getCanonicalName(), constPool);
                jsonFileAnnotation.addMemberValue("name", new StringMemberValue(name,constPool));
                annotationsAttribute.addAnnotation(jsonFileAnnotation);
                value.getFieldInfo().addAttribute(annotationsAttribute);

                ctClass.addField(value);
                System.out.println(name);
                ctClass.addMethod(CtNewMethod.setter("set"+getMethodName(simpleName), value));
                ctClass.addMethod(CtNewMethod.getter("get"+getMethodName(simpleName), value));
            }

        }
        ctClass.writeFile("C:\\workspace\\personal\\DemoSpaceBravo\\target\\classes\\com\\example\\demospacebravo\\dto");
    }
    private static String getMethodName(String fildeName) {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
