package e_commerce.observer;


import e_commerce.classes.order.Pending;
import e_commerce.facade.Order;
import e_commerce.facade.OrderFacade;
import e_commerce.interator.Orderlist;
import e_commerce.interfaces.IOrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Backoffice implements IOrderObserver {

   // public ProductInventory productInventory = ProductInventory.getInstance();


    private Orderlist orderlist = Orderlist.getInstance();

    private OrderFacade orderFacade;



    @Override
    public void notifyOrderChange(Order order) {

        boolean isPending = order.getOrderStatus().equals(orderFacade.getPending());
        boolean isPaid = order.getOrderStatus().equals(orderFacade.getPaid());
        boolean isShipped = order.getOrderStatus().equals(orderFacade.getPaid());

        if (isPending){
            for (int i = 0; i <orderlist.ordersFromCartList.size() ; i++) {
                orderlist.ordersFromCartList.get(i).orderStatus.changeOrderToPaid(order.getCart());
                System.out.println(orderlist.ordersFromCartList.get(i).getOrderStatus());
            }
        }
        if(isPaid){
            for (int i = 0; i <orderlist.ordersFromCartList.size() ; i++) {
                orderlist.ordersFromCartList.get(i).orderStatus.changeOrderToShipped(order.getCart());
                System.out.println(orderlist.ordersFromCartList.get(i).getOrderStatus());
            }
        }
        if(isShipped){
            for (int i = 0; i <orderlist.ordersFromCartList.size() ; i++) {
                orderlist.ordersFromCartList.get(i).orderStatus.changeOrderToCompleted(order.getCart());
                System.out.println(orderlist.ordersFromCartList.get(i).getOrderStatus());
            }
        }


    }

    public void renderOrderList(){

            for (Order order:orderlist.ordersFromCartList){
                 System.out.println("Order was changed "+ order.orderStatus +", order id:  "+ order.getOrderID()+" product list: "+ order.cart.cartList+ " delivery "+ order.getShippingFactory()+ " shipping cost "+order.getShippingPrice());
            }


    }
}
