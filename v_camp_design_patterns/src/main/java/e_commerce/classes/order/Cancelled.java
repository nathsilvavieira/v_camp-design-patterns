package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.interator.Orderlist;
import e_commerce.interfaces.IOrderFacade;
import e_commerce.singleton.ProductInventory;

public class Cancelled implements IOrderFacade {

    private String status = "Order cancelled";

    private ProductInventory productInventory = ProductInventory.getInstance();
    private Orderlist orderlist;

    private Cart cart;



    public String getStatusCancelled() {
        return status;
    }


    @Override
    public void changeOrderStatus() {
       System.out.println(getStatusCancelled());

    }
    @Override
    public String toString() {
        return "Cancelled";

    }

}
