package ATM;

import java.util.Iterator;

/**
 * Created by artur on 9/05/17.
 */
public class ATMDepartment implements Cloneable{
    private ATMNode first;
    private ATMNode last;

    public ATMDepartment (ATMNode first){
        this.first = first;
        this.last = first;
    }

    public void addATM(ATMNode node){
        this.last.setNext(node);
        this.last = node;
    }

    public int getRest(){
        return first.getRest();
    }

    @Override
    public ATMDepartment clone() {
        Node firstClone = first.clone();
        ATMDepartment ATM = new ATMDepartment((ATMNode) firstClone);

        Iterator<ATMNode> iterator = new MyIterator(first);
        while (iterator.hasNext()) {
            ATMNode curr = iterator.next();
            ATMNode nodeClone = (ATMNode) curr.clone();
            ATM.addATM(nodeClone);
            ATM.last = nodeClone;
        }
        return ATM;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ATMDepartment ATM = (ATMDepartment) o;
        Iterator<ATMNode> iterator = new MyIterator(first);
        Iterator<ATMNode> iterator2 = new MyIterator(ATM.first);

        if (!first.equals(ATM.first)) { return false; }

        while (iterator.hasNext()) {
            ATMNode curr = iterator.next();
            ATMNode curr1 = iterator2.next();
            if (!curr.equals(curr1)){
                return false;
            }
            if (iterator.hasNext() != iterator2.hasNext()){
                return false;
            }
        }
        return true;

    }



}
