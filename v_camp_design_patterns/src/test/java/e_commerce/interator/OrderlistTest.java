package e_commerce.interator;

import e_commerce.facade.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderlistTest {

    public Orderlist orderlist = Orderlist.getInstance();



    @Before
    public void addToOrderListTest(){
        orderlist.ordersFromCartList.add(0,new Order());
        orderlist.ordersFromCartList.add(1,new Order());
    }

    @Test
    public void iterator() {
    }

    @Test
    public void hasNext() {

        orderlist.hasNext();
    }

    @Test
    public void next() {
        orderlist.next();
    }
}