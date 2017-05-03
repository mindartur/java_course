package l31;

import java.util.Iterator;

/**
 * Created by artur on 3/05/17.
 */
public class MyIterable<T> implements Iterable<T> {
    public Iterator<T> iterator() {
        return new MyIterator<T>(array);
    }

    private T[] array;

    public MyIterable(int size) {
        array = (T[]) new Object[size];
    }

    public MyIterable(T[] array_2) {
        array = array_2;
    }
}
