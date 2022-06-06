package e_commerce.facade;

import e_commerce.composite.Cart;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.interator.Orderlist;
import e_commerce.interfaces.IOrderObserver;
import e_commerce.observer.OrderObserverMenager;
import e_commerce.singleton.ProductInventory;

import java.util.Random;

public class Order {


    private  int orderID;
    private  double shippingPrice;

    public OrderObserverMenager orderObserverMenager;

    public ProductInventory productInventory = ProductInventory.getInstance();

    public Cart cart = new Cart();

    public ShippingFactory shippingFactory = new ShippingFactory();

    public OrderFacade orderStatus = new OrderFacade();

    public Order() {
        Random random = new Random();
        orderID = random.nextInt(100);
        shippingPrice = cart.calculateShippingCost();
        shippingFactory.createShipping(cart.getWeight());
        Orderlist.getInstance().ordersFromCartList.add(this);
        orderStatus.changeOrderToPending(cart);

    }

    public int getOrderID() {
        return orderID;
    }



}
