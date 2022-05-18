package com.example.demospacebravo;

import com.example.demospacebravo.Annotation.Demo;
import com.example.demospacebravo.dto.PersonDto;
import com.example.demospacebravo.utils.JavassistUtils;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@SpringBootTest
class DemoSpaceBravoApplicationTests {

    @Autowired
    JavassistUtils javassistUtils;

    @Test
    void contextLoads() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NotFoundException, CannotCompileException, IOException {
//       javassistUtils.generateClass();
        loadPerson();
//        loadData();
    }
    private void loadData() throws CannotCompileException, NotFoundException {

        Field[] fields = PersonDto.class.getDeclaredFields();
//        System.out.printf("%d fields:%n", fields.length);
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("PersonDtoShadow");
        ClassFile classFile = ctClass.getClassFile();
        ConstPool constPool = classFile.getConstPool();
        AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        javassist.bytecode.annotation.Annotation jsonFileAnnotation = new Annotation(Demo.class.getCanonicalName(), constPool);
        StringBuilder builder = new StringBuilder();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Demo.class)){
                String simpleName = field.getType().getName();
                field.setAccessible(true);
                String name = field.getAnnotation(Demo.class).name();
                CtField value = new CtField(pool.get(String.class.getCanonicalName()), simpleName,ctClass);
                value.setModifiers(javassist.Modifier.PRIVATE);
                ctClass.addField(value);

                jsonFileAnnotation.addMemberValue("name", new StringMemberValue(name,constPool));
                annotationsAttribute.addAnnotation(jsonFileAnnotation);
                value.getFieldInfo().addAttribute(annotationsAttribute);

                ctClass.addMethod(CtNewMethod.setter("set"+value, value));
                ctClass.addMethod(CtNewMethod.getter("get"+value, value));
            }

        }
    }

    private void loadPerson () throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("PersonDtoShadow");

        CtField name = new CtField(pool.get(String.class.getCanonicalName()), "name",ctClass);
        name.setModifiers(Modifier.PRIVATE);
        ctClass.addField(name);
        CtField age = new CtField(pool.get(Integer.class.getCanonicalName()),"age",ctClass);
        age.setModifiers(Modifier.PRIVATE);
        ctClass.addField(age);

        ClassFile classFile = ctClass.getClassFile();
        ConstPool constPool = classFile.getConstPool();
        AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);

        Annotation jsonFileAnnotation = new Annotation(Demo.class.getCanonicalName(), constPool);
        jsonFileAnnotation.addMemberValue("name", new StringMemberValue("john",constPool));
        annotationsAttribute.addAnnotation(jsonFileAnnotation);
        age.getFieldInfo().addAttribute(annotationsAttribute);

        ctClass.addMethod(CtNewMethod.setter("setName", name));
        ctClass.addMethod(CtNewMethod.setter("setAge", age));
        ctClass.addMethod(CtNewMethod.getter("getName", name));
        ctClass.addMethod(CtNewMethod.getter("getAge", age));

        StringBuilder builder = new StringBuilder();
        builder.append("return \"Person{\" +\n" +
                "                \"name='\" + name + '\\'' +\n" +
                "                \", age='\" + age + '\\'' +\n" +
                "                '}';");
        CtMethod toStringMethod = new CtMethod(pool.get("java.lang.String"), "toString", null, ctClass);
        toStringMethod.setBody(builder.toString());
        ctClass.addMethod(toStringMethod);

        ctClass.writeFile("C:\\workspace\\personal\\DemoSpaceBravo\\target\\classes\\com\\example\\demospacebravo\\dto");
        System.out.println(ctClass.toClass(ClassPool.getDefault().getClassLoader(), Class.class.getProtectionDomain()));
    }

}
