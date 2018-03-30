package fung.java.test.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import fung.java.annotation.MethodInfo;

public class AnnotationTest {

    @Test
    public void testAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("fung.java.annotation.AnnotationExample");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                System.out.println(method.getName());
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    System.out.println(annotation);
                }
            }
        }
    }

}
