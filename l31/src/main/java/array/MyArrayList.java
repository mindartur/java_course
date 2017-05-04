package array;

import javax.naming.SizeLimitExceededException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by artur on 3/05/17.
 */
public class MyArrayList<T> implements Collection<T> {

    private T[] array;
    private int length = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity){
        array = (T[]) new Object[capacity];
    }

    public MyArrayList(T[] array_2){
        array = (T[]) new Object[2 * array_2.length];
        for (int i = 0; i<array_2.length; i++) {
            array[i] = array_2[i];
        }
        length = array_2.length;
    }

    @Override
    public int size() {
        return length;
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
        if (length + 1 > array.length){
            T[] array_2 = (T[]) new Object[array.length * 2];
            for (i=0; i<array.length; i++){
                array_2[i] = array[i];
            }
            array = array_2;
        }
        array[length] = t;
        length += 1;
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

    public T get(int ind) {
        return array[ind];
    }
}
