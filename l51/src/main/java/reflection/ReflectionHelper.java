package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by artur on 5/05/17.
 */
public class ReflectionHelper {
    private ReflectionHelper() {
    }

    static <T> T instantiate(Class<T> type, Object... args) {
        try {
            if (args.length == 0) {
                return type.newInstance();
            }
            else {
                return type.getConstructor(toClasses(args)).newInstance();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    static Object getField(Object object, String name){
        Field field = null;
        boolean isAccesible = true;
        try {
            field = object.getClass().getDeclaredField(name);
            isAccesible = field.isAccessible();
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (field != null && !isAccesible) {
                field.setAccessible(false);
            }
        }
        return null;
    }

    static void setValue(Object object, String name, Object value){
        Field field = null;
        boolean isAccesible = true;
        try {
            field = object.getClass().getDeclaredField(name);
            isAccesible = field.isAccessible();
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (field != null && !isAccesible) {
                field.setAccessible(false);
            }
        }
    }

    static Object callMethod(Object object, String string, Object... args){
        Method method = null;
        boolean isAccessible = true;
        try {
            method = object.getClass().getDeclaredMethod(string, toClasses(args));
            isAccessible = method.isAccessible();
            method.setAccessible(true);
            return method.invoke(object, args);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            if (method != null && !isAccessible) {
                method.setAccessible(false);
            }
        }
        return null;
    }

    static Annotation[] getAnnotations(Object object){
        return object.getClass().getAnnotations();
    }

    static private Class<?>[] toClasses(Object[] args) {
        List<Class<?>> classes = Arrays.stream(args).map(Object::getClass).collect(Collectors.toList());
        return classes.toArray(new Class<?>[classes.size()]);
    }
}
