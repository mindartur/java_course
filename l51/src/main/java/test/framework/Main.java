package test.framework;

import org.junit.*;

/**
 * Created by artur on 7/05/17.
 */



public class Main {
    public static void main(String[] args){
        ClassToTest cls = new ClassToTest();
        Tests.runTests(cls);
        Assert.assertEquals(1, 1);
        Assert.assertTrue(true);
        Assert.fail("My fail message");
    }

}
