package test.framework;

/**
 * Created by artur on 7/05/17.
 */
public class ClassToTest {

    @Test
    public static void runTest2(){
        System.out.println("Test #2");
    }

    @Before
    public static void runBefore(){
        System.out.println("Run before");
    }

    @After
    public static void runAfter(){
        System.out.println("Run after");
    }

    @Test
    public static void runTest1(){
        System.out.println("Test #1");
    }
}
