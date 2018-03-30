package fung.java.test.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import fung.java.reflect.ReflectExample;

public class ReflectTest {

    @Test
    public void testReflect() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("fung.java.reflect.ReflectExample");

        System.out.println("##### Class Name #####");
        System.out.println(clazz.getName());

        System.out.println("##### Public Constructor #####");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("##### Specific Constructor #####");
        Constructor constructor = clazz.getConstructor(String.class);
        System.out.println(constructor);

        System.out.println("##### Fields #####");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("##### Specific Field #####");
        Field field = clazz.getDeclaredField("str");
        System.out.println(field);

        System.out.println("##### Public Methods #####");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("##### Specific Method #####");
        Method method = clazz.getMethod("set" + upperCaseFirstLetter(field.getName()),
                field.getType());

        ReflectExample reflectExample =
                (ReflectExample) clazz.getConstructor().newInstance();
//        field.setAccessible(true);
//        field.set(reflectExample, "hello");
//        System.out.println(reflectExample.getStr());

        method.invoke(reflectExample, "hello");
        System.out.println(reflectExample.getStr());

    }

    private String upperCaseFirstLetter(String str) {
        if (str == null) {
            throw new NullPointerException("输入参数不能为空");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("输入参数不能为空字串");
        }
        return str.replace(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

}
