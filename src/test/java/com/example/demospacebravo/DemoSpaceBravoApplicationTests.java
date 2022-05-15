package com.example.demospacebravo;

import com.example.demospacebravo.Annotation.Demo;
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
import java.lang.reflect.InvocationTargetException;

@SpringBootTest
class DemoSpaceBravoApplicationTests {

    @Autowired
    JavassistUtils javassistUtils;

    @Test
    void contextLoads() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NotFoundException, CannotCompileException, IOException {
//       javassistUtils.generateClass();
        loadPerson();
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

//        ctClass.writeFile("C:\\workspace\\personal\\DemoSpaceBravo\\target\\classes\\com\\example\\demospacebravo\\dto");
        System.out.println(ctClass.toClass(ClassPool.getDefault().getClassLoader(), Class.class.getProtectionDomain()));
    }

}
