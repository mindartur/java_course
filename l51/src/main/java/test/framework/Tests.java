package test.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Tests {
    private Tests() {
    }

    static void runTests(Object object) {
        try {
            for (Method method : object.getClass().getMethods()) {
                if (method.getAnnotationsByType(Before.class).length != 0) {
                    method.invoke(method.getAnnotations(), (Object[]) null);
                }
            }
            for (Method method : object.getClass().getMethods()) {
                if (method.getAnnotationsByType(Test.class).length != 0) {
                    method.invoke(method.getAnnotations(), (Object[]) null);
                }
            }
            for (Method method : object.getClass().getMethods()) {
                if (method.getAnnotationsByType(After.class).length != 0) {
                    method.invoke(method.getAnnotations(), (Object[]) null);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
