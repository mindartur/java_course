package ATM;

import java.util.Collection;

/**
 * Created by artur on 8/05/17.
 */
public interface Node extends Collection, Cloneable {

    public int getBanknoteAmount();
    public int withdrawBanknotes(int amount);
    Node clone();

}
