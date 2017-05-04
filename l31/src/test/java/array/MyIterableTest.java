package array;
import org.junit.*;

/**
 * Created by artur on 4/05/17.
 */
public class MyIterableTest {
    private MyIterable<Integer> myIterable;
    private Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Before
    public void before(){
        myIterable = new MyIterable<>(array);
    }

    @Test
    public void testCycle(){
        int ind = 0;
        for (Integer i : myIterable){
            Assert.assertEquals("Elems not equal", array[ind], i);
            ind ++;
        }
        Assert.assertEquals("Length not equal", array.length, ind);
    }
}
