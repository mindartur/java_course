package ATM;

import java.util.Iterator;

/**
 * Created by artur on 8/05/17.
 */
public class MyIterable implements Iterable {
    public Iterator iterator() {
        return new MyIterator(x);
    }

    private ATMNode x;

    public MyIterable(ATMNode y) {
        x = y;
    }
}
