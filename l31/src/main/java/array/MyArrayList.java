package array;

import javax.naming.SizeLimitExceededException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by artur on 3/05/17.
 */
public class MyArrayList<T> implements Collection<T> {

    private int capacity = 0;
    private T[] array;
    private int index = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity){
        array = (T[]) new Object[capacity];
    }

    public MyArrayList(T[] array_2){
        array = array_2;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(array);
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        int i;
        if (2*array.length > capacity){
            capacity = 2 * array.length + 1;
            T[] array_2 = (T[]) new Object[capacity];
            for (i=0; i<array.length; i++){
                array_2[i] = array[i];
            }
            array = array_2;
        }
        else {
            i = array.length;
        }
        array[i] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
