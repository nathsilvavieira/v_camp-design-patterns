package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.interfaces.IOrderFacade;

public class Paid implements IOrderFacade {

    Cart cart;
    private String status = "Order paid";

    public String getStatus() {
        return status;
    }

    @Override
    public void changeOrderStatus() {
        System.out.println(getStatus());
    }

    @Override
    public String toString() {
        return "Paid";

    }
}
