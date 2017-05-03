package l31;

import java.util.List;

/**
 * Created by artur on 3/05/17.
 */
public class LargestElement {
    public static void main(String[] args){

    }

    private static Integer getLargestElement(Integer[] array){
        if (array.length == 0) {
            return null;
        }
        int max = array[0];
        for (Integer i : array){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    private static <T extends Number> T getLargestElementNumber(List<T> list){
        if (list.size() == 0) {
            return null;
        }
        Number max = list.get(0);

        return null;
    }

}
