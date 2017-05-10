package json;

/**
 * Created by artur on 10/05/17.
 */
public class MySimpleClass {

    private int testInt;
    private String testString;
    private MySimpleClass next;

    public MySimpleClass(int i, String s) {
        testInt = i;
        testString = s;
    }

    public void setNext(MySimpleClass nxt){
        next = nxt;
    }


}
