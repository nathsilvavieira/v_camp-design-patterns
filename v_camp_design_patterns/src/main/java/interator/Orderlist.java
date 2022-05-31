package interator;

import facade.Order;

import java.util.ArrayList;
import java.util.List;

public class Orderlist {

    private Orderlist orderlist;

    public List<Order> orderList = new ArrayList<>();

    private Orderlist(Orderlist orderlist) {
        this.orderlist = orderlist;
    }

    public Orderlist getInstance() {
        return orderlist;
    }

}
