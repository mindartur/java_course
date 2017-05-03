package array;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by artur on 3/05/17.
 */
public class Main {
    public static void main(String[] args){
        Integer[] input_array = {1,2,3,4,5};
        MyArrayList<Integer> myarray = new MyArrayList<>(input_array);
        System.out.println(Collections.max(myarray));
        System.out.println(Collections.addAll(myarray, 10, 20, 30));
        for (int i : myarray){
            System.out.println(i);
        }

    }
}
