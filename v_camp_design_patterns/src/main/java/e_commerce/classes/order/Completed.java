package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.interfaces.IOrderFacade;

public class Completed implements IOrderFacade {

    private String status = "Order completed";

    private Cart cart;

    public String getStatusCompleted() {
        return status;
    }


    @Override
    public void changeOrderStatus() {
        System.out.println(getStatusCompleted());
    }
}
