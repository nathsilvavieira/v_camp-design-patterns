package e_commerce.interator;

import e_commerce.facade.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orderlist implements Iterator<Order> {

    private Orderlist orderlist;

    public List<Order> orderList = new ArrayList<>();

    private Orderlist(Orderlist orderlist) {
        this.orderlist = orderlist;
    }

    public Orderlist getInstance() {
        return orderlist;
    }

    public Iterator<Order> iterator(){
        return new Orderlist(orderlist);
    }
    @Override
    public boolean hasNext() {
        return orderlist.iterator().hasNext();
    }

    @Override
    public Order next() {
        return orderlist.next();
    }
}
