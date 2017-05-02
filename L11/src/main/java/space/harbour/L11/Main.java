package space.harbour.L11;

import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by artur on 1/05/17.
 */
public class Main {
    public static void main(String[] args) {
        String hello = "Hello";
        System.out.println(hello);
        ArrayList <Character> list = new ArrayList<Character>();
        for (char c : hello.toCharArray()){
            list.add(c);
        }
        for (char c : list){
            System.out.println(c);
        }
        Collection<List<Character>> result = Collections2.permutations(list);
        for (List<Character> lst: result){
            for (char c : lst){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
