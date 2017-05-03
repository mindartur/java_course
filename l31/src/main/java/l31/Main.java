package l31;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Iterator;

/**
 * Created by artur on 3/05/17.
 */
public class Main {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4};
        Integer[] array2 = {3,4,5,6,7};
        MyIterable<Integer> iterable = new MyIterable<>(array);
        MyIterable<Integer> iterable2 = new MyIterable<>(array2);

        System.out.println(CollectionUtils.union(iterable,iterable2));
        System.out.println(CollectionUtils.disjunction(iterable, iterable2));
        System.out.println(CollectionUtils.intersection(iterable, iterable2));
    }

}
