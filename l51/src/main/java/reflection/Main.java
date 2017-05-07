package reflection;

import com.sun.corba.se.impl.orb.ParserTable;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by artur on 5/05/17.
 */
public class Main {

    @Resource
    public static class TestClass {
        public String testVar = "Test variable";
        public void testMethod(){
            System.out.println("Empty method!");
        }
    }

    public static void main(String[] args){
        TestClass test = new TestClass();

        for (Annotation i : ReflectionHelper.getAnnotations(test)){
            System.out.println(i.toString());
            boolean b = i.annotationType() == Override.class;

        }

        ReflectionHelper.callMethod(test, "testMethod");
        System.out.println(ReflectionHelper.getField(test, "testVar"));
    }
}
