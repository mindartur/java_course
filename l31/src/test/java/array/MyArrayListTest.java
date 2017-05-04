package array;

import org.junit.*;

/**
 * Created by artur on 4/05/17.
 */
public class MyArrayListTest {

    private MyArrayList<Integer> myListInt;

    @Before
    public void before(){
        myListInt = new MyArrayList<>(5);
    }

    @Test
    public void testAddOne(){
        myListInt.add(10);
        Assert.assertEquals("Wrong size",1, myListInt.size());
        Assert.assertEquals("Wrong last elem", new Integer(10), myListInt.get(0));
    }

    @Test
    public void testAddMany(){
        for (int i=0; i < 100; i++){
            myListInt.add(i);
        }
        Assert.assertEquals("Wrong size",100, myListInt.size());
        for (int i=0; i < 100; i++){
            Assert.assertEquals("Wrong elem", new Integer(i), myListInt.get(i));
        }

    }

    @Test(expected = UnsupportedOperationException.class)
    public void isEmpty(){
        myListInt.isEmpty();
    }

}
