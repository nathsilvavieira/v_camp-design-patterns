package e_commerce.observer;


import e_commerce.facade.Order;
import e_commerce.interator.Orderlist;
import e_commerce.interfaces.IOrderObserver;

public class Backoffice implements IOrderObserver {

   // public ProductInventory productInventory = ProductInventory.getInstance();


    private Orderlist orderlist = Orderlist.getInstance();
    @Override
    public void notifyOrderChange(Order order) {
        //salvar numa lista
        //System.out.println("Order "+ order.getOrderID()+" products"+order.cart.cartList+ " delivery value "+order.cart.calculateShippingCost());

    }

    public void renderOrderList(){
        //renderizar a lista
    }
}
