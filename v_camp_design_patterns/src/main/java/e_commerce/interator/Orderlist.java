package e_commerce.interator;

import e_commerce.facade.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orderlist implements Iterator<Order> {

    private static Orderlist orderlist = Orderlist.getInstance();

    public List<Order> ordersFromCartList = new ArrayList<Order>();

    private int positionList = 0;

    private Orderlist() {
        this.orderlist = orderlist;
    }

    public static Orderlist getInstance() {
        if(orderlist==null){
            orderlist = new Orderlist();
            return orderlist;
        }
        return orderlist;
    }

    public static Iterator<Order> iterator(){
        return new Orderlist();
    }
    @Override
    public boolean hasNext() {
        return !ordersFromCartList.isEmpty();
    }

    @Override
    public Order next() {
        if(!hasNext()){
            return null;
        }
        Order order = ordersFromCartList.get(positionList);
        positionList++;
        return order;
    }
}
