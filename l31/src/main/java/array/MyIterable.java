package array;

import l31.MyIterator;

import java.util.Iterator;

/**
 * Created by artur on 3/05/17.
 */
public class MyIterable<T> implements Iterable<T> {
    public Iterator<T> iterator() {
        return new MyIterator<T>(array);
    }

    private T[] array;

    public MyIterable(T[] array_2) {
        array = array_2;
    }
}
