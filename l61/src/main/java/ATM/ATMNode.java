package ATM;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by artur on 8/05/17.
 */
public class ATMNode implements Node, Cloneable {
    private ATMNode next = null;
    private int banknoteAmount;
    private int nominal;

    public ATMNode(int nominal, int banknoteAmount){
        this.nominal = nominal;
        this.banknoteAmount = banknoteAmount;
    }

    public int getNominal(){
        return nominal;
    }

    public void setBanknoteAmount(int amount) { this.banknoteAmount = amount; }

    public int getBanknoteAmount() {
        return banknoteAmount;
    }

    public int withdrawBanknotes(int amount) {
        if (this.banknoteAmount < amount){
            return -1;
        }
        this.banknoteAmount -= amount;
        return amount;
    }

    @Override
    public Node clone() {
        try {
            return (Node) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void setNext(ATMNode next) { this.next = next; }

    public ATMNode getNext() { return next; }

    public int getRest(){
        int result = this.getNominal() * this.getBanknoteAmount();
        Iterator<ATMNode> iterator = new MyIterator(this);
        while(iterator.hasNext()){
            ATMNode curr = iterator.next();
            result += curr.getNominal() * curr.getBanknoteAmount();
        }
        return result;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public boolean hasNext() { return this.next != null; }

    public int handle(int amount){
        int amountToWithdraw = amount / nominal;
        int result;

        if (amount == 0) {
            return 0;
        }

        if (amountToWithdraw > getBanknoteAmount()) {
            amountToWithdraw = getBanknoteAmount();
        }

        while (amountToWithdraw != 0) {
            banknoteAmount -= amountToWithdraw;
            result = handle(amount - amountToWithdraw * nominal);

            if (result != -1) {
                amount = result;
                break;
            }
            else {
                banknoteAmount += amountToWithdraw;
                amountToWithdraw -= 1;
            }
        }

        if (amount == 0){
            return amount;
        }

        if (!this.hasNext()) {
            return -1;
        }

        return getNext().handle(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ATMNode that = (ATMNode) o;

        return nominal == that.nominal && banknoteAmount == that.banknoteAmount;
    }
}
