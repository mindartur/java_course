package array;
import org.junit.*;

/**
 * Created by artur on 4/05/17.
 */
public class MyIteratorTest {
    private MyIterator<Integer> myIterator;
    private Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Before
    public void before(){
        myIterator = new MyIterator<>(array);
    }

    @Test(timeout = 10)
    public void testNext(){
        Integer next = myIterator.next();
        Assert.assertEquals("Not equals", next, array[0]);
        int ind = 1;
        while (myIterator.hasNext()){
            next = myIterator.next();
            Assert.assertEquals("Not equals", next, array[ind]);
            ind ++;
        }
        Assert.assertEquals("Incorrect size", ind, array.length);
    }

}
