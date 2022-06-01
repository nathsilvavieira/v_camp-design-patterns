package e_commerce.facade;

import e_commerce.classes.order.*;
import e_commerce.composite.Cart;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.interfaces.IOrderFacade;
import e_commerce.model.Product;
import e_commerce.singleton.ProductInventory;

public class OrderFacade implements IOrderFacade {

    Cart cart;

    ShippingFactory shippingFactory;

    ProductInventory productInventory;

    private Pending pending;
    private Paid paid;
    private Completed completed;
    private Shipped shipped;
    private Cancelled cancelled;

    public void Facede(){
        pending = new Pending();
        paid = new Paid();
        completed = new Completed();
        shipped = new Shipped();
        cancelled= new Cancelled();
    }


    @Override
    public void changeOrderStatus(String status, Product product) {
        switch (status.toLowerCase()){
            case "pending":

                pending.getStatus();

                break;
            case "paid":
                paid.getStatus();

                break;
            case  "completed":

                completed.getStatusCompleted();

                break;
            case "shipped":
                shipped.getStatus();

                break;
            case "cancelled":
                pending.getStatus();
                cancelled.OrderCancelled(product);
                System.out.println(cancelled.getStatusCancelled());
                break;
        }

    }
}
