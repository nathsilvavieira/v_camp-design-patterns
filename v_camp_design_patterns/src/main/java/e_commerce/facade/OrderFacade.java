package e_commerce.facade;

import e_commerce.classes.order.*;
import e_commerce.composite.Cart;


public class OrderFacade{

    private Pending pending;
    private Paid paid;
    private Completed completed;
    private Shipped shipped;
    private Cancelled cancelled;

    public OrderFacade(){
        pending = new Pending();
        paid = new Paid();
        completed = new Completed();
        shipped = new Shipped();
        cancelled= new Cancelled();
    }

    public void changeOrderToCancelled(Cart cart){
        cancelled.changeOrderStatus();
    }

    public void changeOrderToPending(Cart cart){
        pending.changeOrderStatus();

    }

    public void changeOrderToPaid(Cart cart){
        paid.changeOrderStatus();

    }

    public void changeOrderToShipped(Cart cart){
        shipped.changeOrderStatus();

    }

    public void changeOrderToCompleted(Cart cart){
        completed.changeOrderStatus();

    }



}
