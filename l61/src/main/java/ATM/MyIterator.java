package ATM;

import java.util.Iterator;

/**
 * Created by artur on 8/05/17.
 */
public class MyIterator implements Iterator {
    public boolean hasNext() {
        return x.hasNext();
    }

    public ATMNode next() {
        if (!x.hasNext()) {
            return null;
        }

        return x.getNext();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
    private ATMNode x;
    public MyIterator(ATMNode y){
        x = y;
    }
}
