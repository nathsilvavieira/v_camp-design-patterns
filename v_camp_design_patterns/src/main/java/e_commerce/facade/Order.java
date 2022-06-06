package e_commerce.facade;

import e_commerce.composite.Cart;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.interator.Orderlist;
import e_commerce.interfaces.IOrderObserver;
import e_commerce.observer.OrderObserverMenager;

import java.util.Random;

public class Order implements IOrderObserver {


    private  int orderID;

    public OrderObserverMenager orderObserverMenager;

    public Cart cart;

    public ShippingFactory shippingFactory;

    public OrderFacade orderStatus;

    public Order() {
        Random random = new Random();
        Orderlist.getInstance().ordersFromCartList.add(this);
        orderStatus.changeOrderToPending(cart);
        shippingFactory.createShipping(cart.getWeight());
        orderID = random.nextInt(100);

    }

    public int getOrderID() {
        return orderID;
    }


    @Override
    public void notifyOrderChange(Order order) {

    }
}
