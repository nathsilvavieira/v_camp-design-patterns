package e_commerce.observer;


import e_commerce.classes.order.Pending;
import e_commerce.facade.Order;
import e_commerce.facade.OrderFacade;
import e_commerce.interator.Orderlist;
import e_commerce.interfaces.IOrderObserver;


public class Backoffice implements IOrderObserver {

    private Orderlist orderlist = Orderlist.getInstance();

    private OrderFacade orderFacade =new OrderFacade();

    @Override
    public void renderOrderList(int orderId){

        System.out.println("\n\nOrder List\n\n");

        for (Order order: orderlist.ordersFromCartList) {
            System.out.println(order);
            order.orderStatus.changeOrderToPending(order.cart);
            order.orderStatus.changeOrderToPaid(order.cart);
            order.orderStatus.changeOrderToShipped(order.cart);
            order.orderStatus.changeOrderToCompleted(order.cart);
        }
    }



}

