package l31;

import java.util.Iterator;

/**
 * Created by artur on 3/05/17.
 */
public class MyIterator<T> implements Iterator<T> {
    public boolean hasNext() {
        return myarray.length-1 >= index;
    }

    public T next() {
        T value = myarray[index];
        index += 1;
        return value;
    }

    public void remove() {

    }
    private T[] myarray;
    private int index = 0;
    public MyIterator(T[] array){
        myarray = array;
    }
}
