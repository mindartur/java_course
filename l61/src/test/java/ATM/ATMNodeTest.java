package ATM;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by artur on 8/05/17.
 */
public class ATMNodeTest {

    public ATMNode node1;
    public ATMNode node2;
    public ATMNode node3;


    @Before
    public void createATM(){
        node1 = new ATMNode(10, 2);
        node2 = new ATMNode(5, 2);
        node3 = new ATMNode(2, 2);
        node1.setNext(node2);
        node2.setNext(node3);
    }


    @Test
    public void withdraw10(){
        Assert.assertEquals(0, node1.handle(10));
        Assert.assertEquals(0, node1.handle(10));
        Assert.assertEquals(0, node1.handle(10));
        Assert.assertEquals(-1, node1.handle(1));
        node1.setBanknoteAmount(3);
        Assert.assertEquals(0, node1.handle(30));
        Assert.assertEquals(-1, node1.handle(20));
    }

    @Test
    public void withdraw5(){
        Assert.assertEquals(0, node1.handle(5));
        Assert.assertEquals(0, node1.handle(5));
        Assert.assertEquals(-1, node1.handle(5));
    }

    @Test
    public void withdraw2(){
        Assert.assertEquals(0, node1.handle(2));
        Assert.assertEquals(0, node1.handle(2));
        Assert.assertEquals(-1, node1.handle(2));
    }

    @Test
    public void withdrawDifferent(){
        node3.setBanknoteAmount(2);
        Assert.assertEquals(0, node1.handle(27));
        Assert.assertEquals(0, node1.getBanknoteAmount());
        Assert.assertEquals(1, node2.getBanknoteAmount());
        Assert.assertEquals(1, node3.getBanknoteAmount());

    }

}
