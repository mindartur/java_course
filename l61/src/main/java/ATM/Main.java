package ATM;

/**
 * Created by artur on 8/05/17.
 */
public class Main {
    public static void main(String[] args){
        ATMNode node1 = new ATMNode(10, 2);
        ATMNode node2 = new ATMNode(5, 2);
        ATMNode node3 = new ATMNode(2, 2);
        node1.setNext(node2);
        node2.setNext(node3);

        node1.handle(17);
        for (Object i : node1){
            System.out.println(i);

        }
    }
}
