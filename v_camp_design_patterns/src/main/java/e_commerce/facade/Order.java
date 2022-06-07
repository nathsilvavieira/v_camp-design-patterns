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

    private String shippingType;

    public OrderObserverMenager orderObserverMenager;

    public ProductInventory productInventory = ProductInventory.getInstance();

    public Cart cart = new Cart();

    public ShippingFactory shippingFactory = new ShippingFactory();

    public OrderFacade orderStatus = new OrderFacade();

    public Order() {
        Random random = new Random();
        this.orderStatus = orderStatus;
        this.orderID = random.nextInt(100);
        this.shippingPrice = shippingPrice;
        this.shippingType = shippingType;
        this.cart = cart;
        Orderlist.getInstance().ordersFromCartList.add(this);
    }

    public OrderFacade  getOrderStatus(){
        return orderStatus;
    }

    public void setOrderStatus(OrderFacade orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }



    @Override
    public String toString() {
        return
                "Order id : " + orderID +
                ", shipping price: " + shippingPrice +
                ", shipping: " + shippingType + ",\n" +
                "products list: " + cart.cartList ;

    }
}
