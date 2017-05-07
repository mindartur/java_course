package test.framework;

/**
 * Created by artur on 7/05/17.
 */
public class Assert {
    public static void fail(java.lang.String message){
        AssertionError error = new AssertionError(message);
        throw error;
    }

    public static void assertTrue(boolean condition){
        assert condition;
    }

    public static void assertEquals(java.lang.Object expected,
                                    java.lang.Object actual){
        assert actual.equals(expected);
    }

}
